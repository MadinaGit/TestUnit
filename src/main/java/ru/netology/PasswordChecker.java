package ru.netology;

public class PasswordChecker {
    protected int minLenght;
    protected int maxRepeats;

    public void setMinLenght(int minLenght) {
        if (minLenght < 0) {
            throw new IllegalArgumentException("Минимальное число не должно быть отрицательным " + minLenght);
        }
        this.minLenght = minLenght;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Максимального количество повторений не должно быть отрицательным или равно нулю " + maxRepeats);
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLenght == -1 || maxRepeats == -1) {
            throw new IllegalStateException("Не все настройки чеккера выставлены правильно");
        }
        if (password.length() < minLenght) {
            return false;
        }

        int repeats = 0;
        char pastSymb = ' ';
        for (char letter : password.toCharArray()) {
            if (letter == pastSymb) {
                repeats++;
            } else {
                repeats = 1;
            }

            if (repeats > maxRepeats) {
                return false;
            }
            pastSymb = letter;
        }
        return true;
    }

}

