public class SecurePassword
{
    private String password;

    public SecurePassword(String password)
    {
        this.password = password;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    public boolean isSecure()
    {
        if (isLongEnough()&&containsUppercase()&&containsLowercase()&&containsDigit()&&containsSpecialSymbol())
        {
            return true;
        }
        return false;
    }

    public String status()
    {
        String message = "";
        if (isSecure())
        {
            return "Password is secure";
        }
        if (!isLongEnough())
        {
            message = message + "The password must be at least 8 characters\n";
        }
        if (!containsUppercase())
        {
            message = message + "The password must contain an uppercase letter\n";
        }
        if (!containsLowercase())
        {
            message = message + "The password must contain an lowercase letter\n";
        }
        if (!containsDigit())
        {
            message = message + "The password must contain a number\n";
        }
        if (!containsSpecialSymbol())
        {
            message = message + "The password must contain a special symbol: ! @ # $ % ^ & * ?\n";
        }
        message = message + "Enter a new, secure password: ";
        return message;
    }

    private boolean isLongEnough()
    {
        return password.length() >= 8;
    }

    private boolean containsUppercase()
    {
        /* this one is completed for you as a hint for how to do the others! */
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);
    }

    private boolean containsLowercase()
    {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }

    private boolean containsDigit()
    {
        String digits = "1234567890";
        return checkString(digits);
    }

    private boolean containsSpecialSymbol()
    {
        String symbols = "!@#$%^&*?";
        return checkString(symbols);
    }

    private boolean checkString(String characterString)
    {
        for (int i = 0;i<password.length();i++)
        {
            for (int c = 0;c<characterString.length();c++)
            {
                if (characterString.substring(c, c+1).equals(password.substring(i, i+1)))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
