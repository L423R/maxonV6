package entities;

import javax.persistence.*;


@Entity
@Table(name = "stavki", schema = "maxdip")
public class StavkiEntity {
    private int id;
    private String наимСтав;
    private String едИзм;
    private Integer кодВида;
    private NprEntity кодНпр;
    private Integer ставкаСпец;
    private Integer ставкаМаг;
    private String примеч;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "НаимСтав", nullable = true, length = 70)
    public String getНаимСтав() {
        return наимСтав;
    }

    public void setНаимСтав(String наимСтав) {
        this.наимСтав = наимСтав;
    }

    @Basic
    @Column(name = "ЕдИзм", nullable = true, length = 255)
    public String getЕдИзм() {
        return едИзм;
    }

    public void setЕдИзм(String едИзм) {
        this.едИзм = едИзм;
    }

    @Basic
    @Column(name = "КодВида", nullable = true)
    public Integer getКодВида() {
        return кодВида;
    }

    public void setКодВида(Integer кодВида) {
        this.кодВида = кодВида;
    }

    @ManyToOne
    @JoinColumn(name = "КодНПР")
    public NprEntity getКодНпр() {
        return кодНпр;
    }

    public void setКодНпр(NprEntity кодНпр) {
        this.кодНпр = кодНпр;
    }

    @Basic
    @Column(name = "Ставка_Спец", nullable = true)
    public Integer getСтавкаСпец() {
        return ставкаСпец;
    }

    public void setСтавкаСпец(Integer ставкаСпец) {
        this.ставкаСпец = ставкаСпец;
    }

    @Basic
    @Column(name = "Ставка_Маг", nullable = true)
    public Integer getСтавкаМаг() {
        return ставкаМаг;
    }

    public void setСтавкаМаг(Integer ставкаМаг) {
        this.ставкаМаг = ставкаМаг;
    }

    @Basic
    @Column(name = "Примеч", nullable = true, length = 255)
    public String getПримеч() {
        return примеч;
    }

    public void setПримеч(String примеч) {
        this.примеч = примеч;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StavkiEntity that = (StavkiEntity) o;

        if (id != that.id) return false;
        if (наимСтав != null ? !наимСтав.equals(that.наимСтав) : that.наимСтав != null) return false;
        if (едИзм != null ? !едИзм.equals(that.едИзм) : that.едИзм != null) return false;
        if (кодВида != null ? !кодВида.equals(that.кодВида) : that.кодВида != null) return false;
        if (кодНпр != null ? !кодНпр.equals(that.кодНпр) : that.кодНпр != null) return false;
        if (ставкаСпец != null ? !ставкаСпец.equals(that.ставкаСпец) : that.ставкаСпец != null) return false;
        if (ставкаМаг != null ? !ставкаМаг.equals(that.ставкаМаг) : that.ставкаМаг != null) return false;
        if (примеч != null ? !примеч.equals(that.примеч) : that.примеч != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (наимСтав != null ? наимСтав.hashCode() : 0);
        result = 31 * result + (едИзм != null ? едИзм.hashCode() : 0);
        result = 31 * result + (кодВида != null ? кодВида.hashCode() : 0);
        result = 31 * result + (кодНпр != null ? кодНпр.hashCode() : 0);
        result = 31 * result + (ставкаСпец != null ? ставкаСпец.hashCode() : 0);
        result = 31 * result + (ставкаМаг != null ? ставкаМаг.hashCode() : 0);
        result = 31 * result + (примеч != null ? примеч.hashCode() : 0);
        return result;
    }

}
