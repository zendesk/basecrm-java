package com.getbase.sync;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import com.getbase.utils.Word;

import java.util.Arrays;
import java.util.List;

public class Meta {
    protected @JsonView(Views.ReadOnly.class) String type;
    protected @JsonView(Views.ReadOnly.class) Sync sync;

    protected Type typeWrapper;

    public static final class Sync {
        private @JsonView(Views.ReadOnly.class) String eventType;
        private @JsonView(Views.ReadOnly.class) String ackKey;
        private @JsonView(Views.ReadOnly.class) Long revision;

        public Sync() {
        }

        public String getEventType() {
            return eventType;
        }

        public String getAckKey() {
            return ackKey;
        }

        public Long getRevision() {
            return revision;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Sync sync = (Sync) o;

            if (eventType != null ? !eventType.equals(sync.eventType) : sync.eventType != null) return false;
            if (ackKey != null ? !ackKey.equals(sync.ackKey) : sync.ackKey != null) return false;
            return !(revision != null ? !revision.equals(sync.revision) : sync.revision != null);

        }

        @Override
        public int hashCode() {
            int result = eventType != null ? eventType.hashCode() : 0;
            result = 31 * result + (ackKey != null ? ackKey.hashCode() : 0);
            result = 31 * result + (revision != null ? revision.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Sync{" +
                    "eventType='" + eventType + '\'' +
                    ", ackKey='" + ackKey + '\'' +
                    ", revision=" + revision +
                    '}';
        }
    }

    public static final class Type {
        public static final List<String> SUPPORTED_TYPES = Arrays.asList(
                "account",
                "user",
                "lead",
                "contact",
                "associated_contact",
                "deal",
                "pipeline",
                "stage",
                "loss_reason",
                "source",
                "note",
                "task",
                "tag"
        );

        private String type;

        public Type(String type) {
            this.type = type;
        }

        public String getType() {
            return this.type;
        }

        public boolean isSupported() {
            return SUPPORTED_TYPES.contains(this.type);
        }

        public String getClassName() {
            return "com.getbase.models." + Word.capitalize(this.type);
        }

        public Class<?> getClassType() throws ClassNotFoundException {
            return Class.forName(getClassName());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Type type1 = (Type) o;

            return !(type != null ? !type.equals(type1.type) : type1.type != null);

        }

        @Override
        public int hashCode() {
            return type != null ? type.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Type{" +
                    "type='" + type + '\'' +
                    '}';
        }

    }

    public Meta() {
    }

    public Type getType() {
        if (this.typeWrapper == null) {
            this.typeWrapper = new Type(this.type);
        }
        return this.typeWrapper;
    }

    public Sync getSync() {
        return sync;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Meta meta = (Meta) o;

        if (type != null ? !type.equals(meta.type) : meta.type != null) return false;
        return !(sync != null ? !sync.equals(meta.sync) : meta.sync != null);

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (sync != null ? sync.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "type='" + type + '\'' +
                ", sync=" + sync +
                '}';
    }
}
