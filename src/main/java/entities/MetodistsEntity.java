package entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Maxon on 01.03.2017.
 */
@Entity
@Table(name = "metodists", schema = "maxdip", catalog = "")
public class MetodistsEntity {
    private String фамилия;
    private String имя;
    private String отчество;
    private String контМет;
    private int id;

    @Basic
    @Column(name = "Фамилия", nullable = true, length = 255)
    public String getФамилия() {
        return фамилия;
    }

    public void setФамилия(String фамилия) {
        this.фамилия = фамилия;
    }

    @Basic
    @Column(name = "Имя", nullable = true, length = 255)
    public String getИмя() {
        return имя;
    }

    public void setИмя(String имя) {
        this.имя = имя;
    }

    @Basic
    @Column(name = "Отчество", nullable = true, length = 255)
    public String getОтчество() {
        return отчество;
    }

    public void setОтчество(String отчество) {
        this.отчество = отчество;
    }

    @Basic
    @Column(name = "Конт_Мет", nullable = true, length = 255)
    public String getКонтМет() {
        return контМет;
    }

    public void setКонтМет(String контМет) {
        this.контМет = контМет;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetodistsEntity that = (MetodistsEntity) o;

        if (id != that.id) return false;
        if (фамилия != null ? !фамилия.equals(that.фамилия) : that.фамилия != null) return false;
        if (имя != null ? !имя.equals(that.имя) : that.имя != null) return false;
        if (отчество != null ? !отчество.equals(that.отчество) : that.отчество != null) return false;
        if (контМет != null ? !контМет.equals(that.контМет) : that.контМет != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = фамилия != null ? фамилия.hashCode() : 0;
        result = 31 * result + (имя != null ? имя.hashCode() : 0);
        result = 31 * result + (отчество != null ? отчество.hashCode() : 0);
        result = 31 * result + (контМет != null ? контМет.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    private Collection<GroupsEntity> groupList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "кодМет",orphanRemoval = true)
    public Collection<GroupsEntity> getGroupList() {
        return groupList;
    }

    public void setGroupList(Collection<GroupsEntity> groupList) {
        this.groupList = groupList;
    }
}
