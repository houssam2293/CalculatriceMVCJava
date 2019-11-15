/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package mvc;

/**
 * @author AsmaPC
 */

// Le modèle effectue toutes les opérations nécessaires.
//Le modèle ne sait pas que la vue existe

public class CalculatorModel {

    double calculate(String str) {

        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') {
                    nextChar();
                }
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) {
                        x += parseTerm();
                    } else if (eat('-')) {
                        x -= parseTerm();
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('×')) {
                        x *= parseFactor();
                    } else if (eat('÷')) {
                        x /= parseFactor();
                    } else if (eat('!')) {
                        x = fact(x);
                    } else {
                        return x;
                    }
                }
            }

            double parseFactor() {
                if (eat('+')) {
                    return parseFactor();
                }
                if (eat('-')) {
                    return -parseFactor();
                }
                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if (eat('e')) {
                    x = Math.E;
                } else if (eat('\u03c0')) {
                    x = Math.PI;
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        nextChar();
                    }
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z' || ch == '\u221a') {
                    while (ch >= 'a' && ch <= 'z' || ch == '\u221a') {
                        nextChar();
                    }
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    switch (func) {
                        case "\u221a":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        default:
                            throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }
                if (eat('^')) {
                    x = Math.pow(x, parseFactor());
                }
                return x;

            }

        }.parse();
    }

    private double fact(double number) {
        double i, b = number;
        if (number != 0) {
            for (i = 1; i <= b; i++)
                number = number * i;
            return number;
        } else return 1;
    }

}
