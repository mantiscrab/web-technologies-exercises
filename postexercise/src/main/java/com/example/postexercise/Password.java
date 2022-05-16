package com.example.postexercise;

class Password {
    String password;

    public String getPassword() {
        return password;
    }

    public Password(final String password) {
        this.password = password;
    }

    public boolean isLongEnough() {
        return (password.length() >= 5);
    }

    public boolean hasUpperCase() {
        boolean hasUpperCase = false;
        for (final char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
        }
        return hasUpperCase;
    }

    public boolean hasLowerCase() {
        boolean hasLowerCase = false;
        for (final char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
            }
        }
        return hasLowerCase;
    }

    public boolean hasDigit() {
        boolean hasDigit = false;
        for (final char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        return hasDigit;
    }

    public boolean isStrong() {
        return hasLowerCase() && hasUpperCase() && hasDigit() && isLongEnough();
    }
}
