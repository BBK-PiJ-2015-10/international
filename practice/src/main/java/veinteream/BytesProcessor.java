package veinteream;

public class BytesProcessor {

    // 1 kibibyte KiB = 1024 bytes
    // 1 mebibyte MiB = (1024*1024) = 1048575 bytes

    /**
     * @param bytesQuantity
     * @return if lower than 1 KiB => return it as string
     * if between 1KiB and 1MiB (exclude it) => convert to KiB, round down, follow by space
     * and the word KiB
     * if equal or greater than 1 MiB, round down, return follow by word MiB
     */

    private Integer oneKiB = 1024;
    private Integer oneMiB = 1048575;

    public String compute(int bytesQuantity) {
        if (bytesQuantity < oneKiB) {
            return Integer.valueOf(bytesQuantity).toString();
        }
        if (bytesQuantity < oneMiB) {
            Integer kiBs = bytesQuantity / oneKiB;
            return kiBs + " KiB";
        }
        Integer miBs = bytesQuantity / oneMiB;
        return miBs + " MiB";
    }

}
