package dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Maxon on 01.03.2017.
 */
@Entity
@Table(name = "napravl", schema = "maxdip", catalog = "")
public class NapravlEntity {
    private String наимНапр;
    private int id;

    @Basic
    @Column(name = "НаимНапр", nullable = true, length = 255)
    public String getНаимНапр() {
        return наимНапр;
    }

    public void setНаимНапр(String наимНапр) {
        this.наимНапр = наимНапр;
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

        NapravlEntity that = (NapravlEntity) o;

        if (id != that.id) return false;
        if (наимНапр != null ? !наимНапр.equals(that.наимНапр) : that.наимНапр != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = наимНапр != null ? наимНапр.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    private Collection<ProgsEntity> progsList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "napralv")
    public Collection<ProgsEntity> getProgsList() {
        return progsList;
    }

    public void setProgsList(Collection<ProgsEntity> progsList) {
        this.progsList = progsList;
    }
}
