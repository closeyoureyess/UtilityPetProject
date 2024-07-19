package genclasses;

import constants.CharConstants;
import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Getter
@Setter
public class AuxiliaryActions {

    CharConstants charConstants = new CharConstants(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',},
            new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
                    'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                    'ъ', 'ы', 'ь', 'э', 'ю', 'я'},
            new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'});

    public char getCharCycle(int cycleCount, String[] arraysFromList) {
        char charString = arraysFromList[cycleCount].trim().charAt(cycleCount);
        return charString;
    }

    public void iterationByElementsStringArray(int counterArrStr, String[] arraysFromList) {
        while (counterArrStr < arraysFromList.length) {
            if (counterArrStr < arraysFromList.length - 1) {
                parseElementsLineFromArray(new StringBuffer(arraysFromList[counterArrStr]));
                counterArrStr++;
            }
            if (counterArrStr == arraysFromList.length - 1) {
                parseElementsLineFromArray(new StringBuffer(arraysFromList[counterArrStr]), counterArrStr);
                counterArrStr++;
            }
        }
    }

    private List<List<?>> parseElementsLineFromArray(StringBuffer line, Integer... lenghArrayString) {
        StringBuffer stringBufferRresult = null;
        StringBuffer stringBufferEresult;
        StringBuffer stringBufferIntegers;
        StringBuffer stringBufferFloats;
        Queue<StringBuffer> resultLines = new LinkedList<>();
        Queue<Integer> resultIntegerNumber = new LinkedList<>();
        Queue<Float> resultFloatNumber = new LinkedList<>();
        //Перебрать строку в цикле
        for (int i = 0; i < line.length(); i++) {
            stringBufferFloats = cycleFractionalNumber(line, i);
            stringBufferRresult = cycleRusAlphapet(line, i);
            stringBufferEresult = cycleEngAlphapet(line, i);
            if (line.toString().contains(".") && lenghArrayString == null) {
                resultFloatNumber.offer(Float.valueOf(String.valueOf(stringBufferFloats)));
            }
            if (line.toString().contains(".") && lenghArrayString != null) {
                resultFloatNumber.offer(Float.valueOf(String.valueOf(stringBufferFloats.append("\n"))));
            }
            if (lenghArrayString == null && stringBufferRresult != null) {
                resultLines.offer(stringBufferRresult);
            }
            if (lenghArrayString == null && stringBufferEresult != null) {
                resultLines.offer(stringBufferEresult);
            }
            if (lenghArrayString != null && stringBufferRresult != null) {
                resultLines.offer(stringBufferRresult.append("\n"));
            }
            if (lenghArrayString != null && stringBufferEresult != null) {
                resultLines.offer(stringBufferEresult.append("\n"));
            }
        }
        while (!resultLines.isEmpty()) {
            stringBufferRresult = resultLines.poll().append(0);
        }

        return null;
    }

    private StringBuffer cycleRusAlphapet(StringBuffer line, int i) {
        int k = 0;
        while (k < charConstants.rusAlphabet().length) {
            if (line.charAt(i) == charConstants.rusAlphabet()[k]) {
                return new StringBuffer(String.valueOf(line.charAt(i)));
            }
            k++;
        }
        return null;
    }

    private StringBuffer cycleEngAlphapet(StringBuffer line, int i) {
        int k = 0;
        while (k < charConstants.engAlphabet().length) {
            if (line.charAt(i) == charConstants.engAlphabet()[k]) {
                return new StringBuffer(String.valueOf(line.charAt(i)));
            }
            k++;
        }
        return null;
    }

    private StringBuffer cycleFractionalNumber(StringBuffer line, int i) {
        int k = 0;
        while (k < line.length()) {
            line.codePointCount()
            if (line.indexOf())
                k++;
        }
        return null;
    }

    private StringBuffer cycleInteger(StringBuffer line, int i) { // Дуб1.783.
        int k = 0;
        while (k < charConstants.arabicNumbers().length) {
            if (line.charAt(i) == charConstants.arabicNumbers()[k]) {
                k = 0;
                return new StringBuffer(String.valueOf(line.charAt(i)));
            }
            k++;
        }
        return null;
    }

    private int lookingDotAmount(StringBuffer line) {
        int dotAmount = String.valueOf(line).split("\\.").length - line.length();
        return dotAmount;
    }
}
