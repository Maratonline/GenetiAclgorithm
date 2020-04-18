package calculation;

import config.Parametr;
import genom.Genom;
import main.GenetickAlgorithm;

public interface Calculatable<N extends  Number> {
    final String ALL_DIGITALS = "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
            "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
            "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
            "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";

    N parce (Parametr.Formula formula, Genom genom);
}
