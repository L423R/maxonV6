package dao;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Maxon on 06.03.2017.
 */
@Entity
@Table(name = "npr", schema = "maxdip", catalog = "")
public class NprEntity {
    private int id;
    private String наимНпр;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "НаимНПР", nullable = true, length = 70)
    public String getНаимНпр() {
        return наимНпр;
    }

    public void setНаимНпр(String наимНпр) {
        this.наимНпр = наимНпр;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NprEntity nprEntity = (NprEntity) o;

        if (id != nprEntity.id) return false;
        if (наимНпр != null ? !наимНпр.equals(nprEntity.наимНпр) : nprEntity.наимНпр != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (наимНпр != null ? наимНпр.hashCode() : 0);
        return result;
    }

    private Collection<PrepsEntity> prepsList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "кодНпр")
    public Collection<PrepsEntity> getPrepsList() {
        return prepsList;
    }

    public void setPrepsList(Collection<PrepsEntity> prepsList) {
        this.prepsList = prepsList;
    }
}
