package org.example;
public class Group {
    private String groupId; // Changed from int to String

    public Group(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Group group = (Group) obj;
        return groupId != null ? groupId.equals(group.groupId) : group.groupId == null;
    }

    @Override
    public int hashCode() {
        return groupId != null ? groupId.hashCode() : 0;
    }
}
