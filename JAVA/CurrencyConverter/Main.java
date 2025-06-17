package CurrencyConverter;

// import java.util.*;
// import java.text.DecimalFormat;

// class Main {
//   public static void main(String[] args) {
//     double rupee,dollar,pound,code,euro,yen;
//     DecimalFormat f = new DecimalFormat("##.##");
//     Scanner input = new Scanner(System.in);

//     Currency cur1 = Currency.getInstance("INR");  
//     String rupeeSymbol = cur1.getSymbol(); 
//     Currency cur2 = Currency.getInstance("USD");  
//     String dollarSymbol = cur2.getSymbol();  
//     Currency cur3 = Currency.getInstance(Locale.UK);  
//     String poundSymbol = cur3.getSymbol(Locale.UK);
//     Currency cur4 = Currency.getInstance("EUR");  
//     String euroSymbol = cur4.getSymbol(Locale.FRANCE);
//     Currency cur5 = Currency.getInstance("JPY");
//     String yenSymbol = cur5.getSymbol(Locale.JAPAN);
      
//     System.out.print("\n");
//     printer("Welcome to a Currency Converter", 65);
//     for(;;){  
//       printer("-", 65);
//     System.out.print("\nThe currencies are as followed:\n1. Ruppe\n2. Dollar\n3. Pound\n4. Euro\n5. Yen\n\nEnter a number from above given currencies to convert: ");
//     code = input.nextInt();
//     //For Rupees Conversion
//     if(code == 1) {
//       System.out.print("\n");
//       printer("|Rupees Conversion|", 65);
//       System.out.print("\n");
//       System.out.print("Enter amount in Rupees: "+rupeeSymbol);
//       rupee = input.nextFloat();
//       dollar = rupee / 81.4117;
//       System.out.println(rupeeSymbol+rupee+ " Rs are "+ dollarSymbol+f.format(dollar) + " Dollars");
//       pound = rupee / 98;
//       System.out.println(rupeeSymbol+rupee + " Rs are "+poundSymbol+f.format(pound)+ " Pounds");
//       euro = rupee / 84.9107;
//       System.out.println(rupeeSymbol+rupee + " Rs are "+euroSymbol+f.format(euro)+" Euros");
//       yen = rupee / 0.587049;
//       System.out.println(rupeeSymbol+rupee+" Rs are "+yenSymbol+f.format(yen)+" Yens");
//       System.out.print("\n");
//       System.out.println("Press CTRL+C to exit");
//     }
//     //For Dollar Conversion
//     else if (code == 2) {
//       System.out.print("\n");
//       printer("|Dollar Conversion|", 65);
//       System.out.print("\n");
//       System.out.print("Enter amount in Dollar: "+dollarSymbol);
//       dollar = input.nextFloat();
//       rupee = dollar * 81.71250;
//       System.out.println(dollarSymbol+dollar+" Dollars are "+rupeeSymbol+f.format(rupee)+" Rs");
//       pound = dollar * 0.827817;
//       System.out.println(dollarSymbol+dollar+" Dollars are "+poundSymbol+f.format(pound)+" Pounds");
//       euro = dollar * 0.961890;
//       System.out.println(dollarSymbol+dollar+" Dollars are "+euroSymbol+f.format(euro)+" Euros");
//       yen = dollar * 139.122;
//       System.out.println(dollarSymbol+dollar+" Dollars are "+yenSymbol+f.format(yen)+" Yens");
//       System.out.print("\n");
//       System.out.println("Press CTRL+C to exit");
//     }
//     //For Pound Conversion
//     else if(code == 3) {
//       System.out.print("\n");
//       printer("|Pound Conversion|", 65);
//       System.out.print("\n");
//       System.out.print("Enter amount in Pound: "+poundSymbol);
//       pound = input.nextFloat();
//       rupee = pound * 98;
//       System.out.println(poundSymbol+pound+" Pounds are "+rupeeSymbol+f.format(rupee)+" Rs");
//       dollar = pound * 1.49;
//       System.out.println(poundSymbol+pound+" Pounds are "+dollarSymbol+f.format(dollar)+" Dollars");
//       euro = pound * 1.36;
//       System.out.println(poundSymbol+pound+" Pounds are "+euroSymbol+f.format(euro)+" Euros");
//       yen = pound * 179.89;
//       System.out.println(poundSymbol+pound+" Pounds are "+yenSymbol+f.format(euro)+" Yens");
//       System.out.print("\n");
//       System.out.println("Press CTRL+C to exit");
//     }
//     //For Euro Conversion
//     else if(code == 4) {
//       System.out.print("\n");
//       printer("|Euro Conversion|", 65);
//       System.out.print("\n");
//       System.out.print("Enter amount in Euro: "+euroSymbol);
//       euro = input.nextFloat();
//       rupee = euro * 85.06;
//       System.out.println(euroSymbol+euro+" Euros are "+rupeeSymbol+f.format(rupee)+" Rupees");
//       dollar = euro * 1.09; 
//       System.out.println(euroSymbol+euro+" Euros are "+dollarSymbol+f.format(dollar)+" Dollars");
//       pound = euro * 0.73;
//       System.out.println(euroSymbol+euro+" Euros are "+poundSymbol+f.format(pound)+" Pounds");
//       yen = euro * 131.84;
//       System.out.println(euroSymbol+euro+" Euros are "+yenSymbol+f.format(yen)+" Yens");
//       System.out.print("\n");
//       System.out.println("Press CTRL+C to exit");
//     }
//     //For Yen Conversion
//     else if(code == 5) {
//       System.out.print("\n");
//       printer("|Yen Conversion|", 65);
//       System.out.print("\n");
//       System.out.print("Enter amount in Yens: "+yenSymbol);
//       yen = input.nextFloat();
//       rupee = yen * 0.55;
//       System.out.println(yenSymbol+yen+" Yens are "+rupeeSymbol+f.format(rupee)+" Rupees");
//       dollar = yen * 0.01;
//       System.out.println(yenSymbol+yen+" Yens are "+dollarSymbol+f.format(dollar)+" Dollars");
//       pound = yen * 0.01;
//       System.out.println(yenSymbol+yen+" Yens are "+poundSymbol+f.format(pound)+" Pounds");
//       euro = yen * 0.01;
//       System.out.println(yenSymbol+yen+" Yens are "+euroSymbol+f.format(euro)+" Euros");
//       System.out.print("\n");
//       System.out.println("Press CTRL+C to exit");
//     }
//     else
//       System.out.println("Invalid Code");
//     }
//   }

//   static void printer(String str, int size) {
//     int left = (size - str.length()) / 2;
//     int right = size - left - str.length();
//     String repeatedChar = "-";
//     StringBuffer buff = new StringBuffer();
//     for (int i = 0; i < left; i++) {
//       buff.append(repeatedChar);
//     }
//     buff.append(str);
//     for (int i = 0; i < right; i++) {
//       buff.append(repeatedChar);
//     }

//     System.out.println(buff.toString());
//   }
// }





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main extends JPanel {
    enum Currency {
        USD("United States Dollar"),
        GBR("Great Britain Pound"),
        AUD("Australian Dollar"),
        EUR("Euro");

        private String description;

        Currency(String description) {
            this.description = description;
        }

        @Override public String toString() {
            return this.name() + " - " + this.description;
        }
    }

    class CurrencyPair {
        private final Currency from;
        private final Currency to;

        public CurrencyPair(Currency from, Currency to) {
            this.from = from;
            this.to = to;
        }

        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CurrencyPair that = (CurrencyPair) o;
            if (from != that.from) return false;
            return to == that.to;
        }

        @Override public int hashCode() {
            int result = from.hashCode();
            result = 31 * result + to.hashCode();
            return result;
        }
    }

    private final Map<CurrencyPair, BigDecimal> exchangeRates = new HashMap<CurrencyPair, BigDecimal>() {{
        put(new CurrencyPair(Main.Currency.USD, Main.Currency.USD), BigDecimal.valueOf(1));
        put(new CurrencyPair(Main.Currency.AUD, Main.Currency.AUD), BigDecimal.valueOf(1));
        put(new CurrencyPair(Main.Currency.EUR, Main.Currency.EUR), BigDecimal.valueOf(1));
        put(new CurrencyPair(Main.Currency.GBR, Main.Currency.GBR), BigDecimal.valueOf(1));

        put(new CurrencyPair(Main.Currency.USD, Main.Currency.GBR), BigDecimal.valueOf(0.75));
        put(new CurrencyPair(Main.Currency.USD, Main.Currency.AUD), BigDecimal.valueOf(1.33));
        put(new CurrencyPair(Main.Currency.USD, Main.Currency.EUR), BigDecimal.valueOf(0.89));

        put(new CurrencyPair(Main.Currency.EUR, Main.Currency.USD), BigDecimal.valueOf(1.12));
        put(new CurrencyPair(Main.Currency.EUR, Main.Currency.AUD), BigDecimal.valueOf(1.49));
        put(new CurrencyPair(Main.Currency.EUR, Main.Currency.GBR), BigDecimal.valueOf(0.85));

        put(new CurrencyPair(Main.Currency.AUD, Main.Currency.USD), BigDecimal.valueOf(0.74));
        put(new CurrencyPair(Main.Currency.AUD, Main.Currency.EUR), BigDecimal.valueOf(0.67));
        put(new CurrencyPair(Main.Currency.AUD, Main.Currency.GBR), BigDecimal.valueOf(0.57));

        put(new CurrencyPair(Main.Currency.GBR, Main.Currency.USD), BigDecimal.valueOf(1.33));
        put(new CurrencyPair(Main.Currency.GBR, Main.Currency.EUR), BigDecimal.valueOf(1.18));
        put(new CurrencyPair(Main.Currency.GBR, Main.Currency.AUD), BigDecimal.valueOf(1.76));

    }};

    public Main() {
        super(new FlowLayout(FlowLayout.LEADING));

        // Amount
        JTextField amountInput = new JTextField(20);
        JPanel amount = new JPanel();
        amount.add(amountInput);
        amount.setBorder(BorderFactory.createTitledBorder("Enter Ammount"));
        add(amount, BorderLayout.CENTER);

        // From
        JPanel from = new JPanel();
        JComboBox fromOptions = new JComboBox(Currency.values());
        from.add(fromOptions);
        from.setBorder(BorderFactory.createTitledBorder("Select currency"));
        add(from, BorderLayout.CENTER);

        // To
        JComboBox toOptions = new JComboBox(Currency.values());
        JPanel to = new JPanel();
        to.add(toOptions);
        to.setBorder(BorderFactory.createTitledBorder("Convert to"));
        add(to, BorderLayout.CENTER);

        // Convert Action
        JLabel convertText = new JLabel();
        JButton convertCmd = new JButton("Convert");
        convertCmd.addActionListener(convertAction(amountInput, fromOptions, toOptions, convertText));
        JPanel convert = new JPanel();
        convert.add(convertCmd);
        convert.add(convertText);
        add(convert);
    }

    private ActionListener convertAction(
            final JTextField amountInput,
            final JComboBox fromOptions,
            final JComboBox toOptions,
            final JLabel convertText) {

        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO: Needs proper validation
                String amountInputText = amountInput.getText();
                if ("".equals(amountInputText)) { return; }

                // Convert
                BigDecimal conversion = convertCurrency(amountInputText);
                convertText.setText(NumberFormat
                        .getCurrencyInstance(Locale.US)
                        .format(conversion));
            }

            private BigDecimal convertCurrency(String amountInputText) {
                // TODO: Needs proper rounding and precision setting
                CurrencyPair currencyPair = new CurrencyPair(
                        (Currency) fromOptions.getSelectedItem(),
                        (Currency) toOptions.getSelectedItem());
                BigDecimal rate = exchangeRates.get(currencyPair);
                BigDecimal amount = new BigDecimal(amountInputText);
                return amount.multiply(rate);
            }
        };
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new Main());
        frame.setTitle("Currency Thing");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}