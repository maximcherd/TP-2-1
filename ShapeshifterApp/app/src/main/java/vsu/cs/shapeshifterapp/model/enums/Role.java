package vsu.cs.shapeshifterapp.model.enums;

public enum Role {
    Guest(0),
    User(1),
    Admin(2);

    public final int value;

    Role(int value) {
        this.value = value;
    }
}
