import sys
import subprocess

try:
    import pyqrcode
except ImportError:
    subprocess.check_call([sys.executable, "-m", "pip", "install", "pyqrcode"])
    import pyqrcode

# String which represent the QR code
# s = "https://www.instagram.com/python.times/"
while True:
  print("\nEnter url that you want to covert into QR Code:")
  s = input()
# Generate QR code
  url = pyqrcode.create(s)

# Create and save the file
  url.svg("myQR.svg", scale=8)

  check = input(
    "\nDo you want make QR code again?\nEnter Y for yes and N for no: ")
  if check.upper() == "Y":
    continue
  elif check.upper() == "N":
    print("\nThanks for using")
    break