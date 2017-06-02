package entities;

import javax.persistence.*;

/**
 * Created by Maxon on 08.04.2017.
 */
@Entity
@Table(name = "god", schema = "maxdip", catalog = "")
public class GodEntity {
    private int id;
    private String лицо;
    private String должн;
    private String фио;
    private String довер;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Лицо", nullable = true, length = 255)
    public String getЛицо() {
        return лицо;
    }

    public void setЛицо(String лицо) {
        this.лицо = лицо;
    }

    @Basic
    @Column(name = "Должн", nullable = true, length = 255)
    public String getДолжн() {
        return должн;
    }

    public void setДолжн(String должн) {
        this.должн = должн;
    }

    @Basic
    @Column(name = "ФИО", nullable = true, length = 255)
    public String getФио() {
        return фио;
    }

    public void setФио(String фио) {
        this.фио = фио;
    }

    @Basic
    @Column(name = "Довер", nullable = true, length = 255)
    public String getДовер() {
        return довер;
    }

    public void setДовер(String довер) {
        this.довер = довер;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GodEntity godEntity = (GodEntity) o;

        if (id != godEntity.id) return false;
        if (лицо != null ? !лицо.equals(godEntity.лицо) : godEntity.лицо != null) return false;
        if (должн != null ? !должн.equals(godEntity.должн) : godEntity.должн != null) return false;
        if (фио != null ? !фио.equals(godEntity.фио) : godEntity.фио != null) return false;
        if (довер != null ? !довер.equals(godEntity.довер) : godEntity.довер != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (лицо != null ? лицо.hashCode() : 0);
        result = 31 * result + (должн != null ? должн.hashCode() : 0);
        result = 31 * result + (фио != null ? фио.hashCode() : 0);
        result = 31 * result + (довер != null ? довер.hashCode() : 0);
        return result;
    }
}
