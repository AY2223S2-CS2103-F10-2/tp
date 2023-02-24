package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's nickname in the address book. Guarantees: immutable; is always valid
 */
public class Nickname {
    public final String value;

    public Nickname(String nickname) {
        requireNonNull(nickname);
        value = nickname;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Nickname && value.equals(((Nickname) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
