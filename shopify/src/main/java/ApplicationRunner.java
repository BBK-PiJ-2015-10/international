public class ApplicationRunner {

    public static void main(String[] args) {

        Processor processor = new Processor();


        //System.out.println("This is a test");

        /*
        Your previous Plain Text content is preserved below:

        Postal Codes
        Description

        We want to cross-check postal codes and provinces/territories to improve the accuracy of Canadian addresses entered into our system.

        Canadian postal codes are in the form "A1A 1A1", where "A" is an upper case letter and "1" is a digit. Note the space between the third and fourth characters. Moreover, all letters should be upper case.

        Each province/territory has a unique set of prefixes:

| Province/Territory        | Province Code | Prefixes      |
| :------------------------ | :------------ | :------------ |
| Newfoundland and Labrador | NL            | A             |
| Nova Scotia               | NS            | B             |
| Prince Edward Island      | PE            | C             |
| New Brunswick             | NB            | E             |
| Quebec                    | QC            | G, H, J       |
| Ontario                   | ON            | K, L, M, N, P |
| Manitoba                  | MB            | R             |
| Saskatchewan              | SK            | S             |
| Alberta                   | AB            | T             |
| British Columbia          | BC            | V             |
| Nunavut                   | NU            | X0A, X0B, X0C |
| Northwest Territories     | NT            | X0E, X0G, X1A |
| Yukon                     | YT            | Y             |

            Behaviour

        Write the following two functions:


        Boolean is_valid_postal_code(String postal_code, String province_code)
        Returns true if the postal_code has the right prefix string
        for the given province_code, or false otherwise.

            Optional[String] province_for_postal_code(String postal_code)
        Returns the province (or territory) according to the specified
        postal_code (the prefix should match the first(s) characters
            of the given postal_code), or null otherwise.

            You should not assume the postal code string has the correct syntax, but you can assume that a provided province code is correctly formatted.
            Input/Output Expectations

        Here is a list of input/output examples:

        is_valid_postal_code("B0P 1X0", "NS") => true
        is_valid_postal_code("b0P 1x0", "NS") => false
        is_valid_postal_code("M5W 1E6", "QC") => false
        is_valid_postal_code("X0A 0H0", "NU") => true
        is_valid_postal_code("V0F G5A", "BC") => false
        is_valid_postal_code("X0A0H0", "NU") => false
        is_valid_postal_code("V0G 3E3", "BC") => true
        is_valid_postal_code("B0P 1X", "NS") => false
        is_valid_postal_code("B0P 1X0B", "NS") => false

        province_for_postal_code("P3E 5P9") => "ON"
        province_for_postal_code("P3e 5p9") => null
        province_for_postal_code("P3E N0M") => null
        province_for_postal_code("X0E 0T0") => "NT"
        province_for_postal_code("Q1Q 1Q1") => null
        province_for_postal_code("Y1A 1V6") => "YT"
        province_for_postal_code("Y1A1V6") => null
        province_for_postal_code("P3E 5P") => null
        province_for_postal_code("Y1A 1V66") => null

            */

    }
}
