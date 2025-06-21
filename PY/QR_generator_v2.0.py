import qrcode
from PIL import Image, ImageDraw, ImageFont
import os

# Define the profiles and their URLs
profiles = {
    "linktr": "https://linktr.ee/its.rushi",
    "GitHub": "https://github.com/rushhiii",
    "Website": "https://rushhiii.github.io/portfolio/"
    # "Twitter": "https://twitter.com/rushhiii"
}

# Output folder
output_dir = "qr_codes"
os.makedirs(output_dir, exist_ok=True)

# Load a font (default to PIL's fallback if Arial is not available)
try:
    font = ImageFont.truetype("arial.ttf", 24)
except:
    font = ImageFont.load_default()

# Generate a QR code for each profile
for label, url in profiles.items():
    # Generate QR code
    qr = qrcode.QRCode(version=1, box_size=10, border=4)
    qr.add_data(url)
    qr.make(fit=True)
    qr_img = qr.make_image(fill_color="black", back_color="white").convert("RGB")

    # Add space below QR code for a label
    width, height = qr_img.size
    new_img = Image.new("RGB", (width, height + 50), "white")
    new_img.paste(qr_img, (0, 0))

    # Draw the label text
    draw = ImageDraw.Draw(new_img)
    text = f"{label} QR"
    bbox = draw.textbbox((0, 0), text, font=font)
    text_width = bbox[2] - bbox[0]
    draw.text(((width - text_width) / 2, height + 10), text, font=font, fill="black")

    # Save the final image
    filename = os.path.join(output_dir, f"{label.lower()}_qr.png")
    new_img.save(filename)
    print(f"✅ Saved {filename}")
