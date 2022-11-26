package pta;

import java.text.SimpleDateFormat;
import java.util.*;


public class Type {

    public enum TypeEnum {
        ZERO,
        ONE
    }

    private TypeEnum type;

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getTypeString() {
        switch (type) {
            case ZERO:
                return "ZERO";
            case ONE:
                return "ONE";
            default:
                return "OTHER";
        }
    }
}
