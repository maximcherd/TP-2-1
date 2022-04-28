package vsu.cs.shapeshifterapp.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.UUID;

import lombok.Data;

@Data
public class Picture {
    private UUID id = UUID.randomUUID();
    private 

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
