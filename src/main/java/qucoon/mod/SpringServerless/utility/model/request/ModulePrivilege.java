package qucoon.mod.SpringServerless.utility.model.request;


import java.util.Objects;

public class ModulePrivilege {

    private final String module;
    private final String privilege;

    public ModulePrivilege(String module, String privilege) {
        this.module = module;
        this.privilege = privilege;
    }

    public String getModule() {
        return module;
    }

    public String getPrivilege() {
        return privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModulePrivilege)) return false;
        ModulePrivilege that = (ModulePrivilege) o;
        return Objects.equals(module, that.module) &&
                Objects.equals(privilege, that.privilege);
    }

    @Override
    public int hashCode() {
        return Objects.hash(module, privilege);
    }

    @Override
    public String toString() {
        return "ModulePrivilege{" +
                "module='" + module + '\'' +
                ", privilege='" + privilege + '\'' +
                '}';
    }
}

