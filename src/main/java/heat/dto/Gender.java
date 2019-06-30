package heat.dto;

public enum Gender {
    MALE(1),
    FEMALE(2),
    OTHER(3);

    private final int index;

    Gender(int index) {
        this.index = index;
    }

    public int index() {
        return index;
    }
}
