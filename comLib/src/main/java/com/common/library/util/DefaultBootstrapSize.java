package com.common.library.util;

public enum DefaultBootstrapSize {

    XS(),
    SM(),
    MD(),
    LG(),
    XL();

    public static DefaultBootstrapSize fromAttributeValue(int attrValue) {
        switch (attrValue) {
            case 0:
                return XS;
            case 1:
                return SM;
            case 2:
                return MD;
            case 3:
                return LG;
            case 4:
                return XL;
            default:
                return MD;
        }
    }

    public float scaleFactor() {
        switch (this) {
            case XS:
                return 0.70f;
            case SM:
                return 0.85f;
            case MD:
                return 1.00f;
            case LG:
                return 1.30f;
            case XL:
                return 1.60f;
            default:
                return 1.00f;
        }
    }
}
