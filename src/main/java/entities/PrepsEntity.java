package entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Maxon on 06.03.2017.
 */
@Entity
@Table(name = "preps", schema = "maxdip")
public class PrepsEntity {
    private Boolean прАрх;
    private NprEntity кодНпр;
    private KafEntity кодКаф;
    private String фамилия;
    private String имя;
    private String отчество;
    private Timestamp датаРожд;
    private String пол;
    private String индекс;
    private String адрес;
    private String почта;
    private String телефон;
    private String серияП;
    private String номерП;
    private String паспорт;
    private String образование;
    private String наимСтеп;
    private String наимЗван;
    private String должн;
    private String наимВнеш;
    private String спс;
    private String инн;
    private String договорНомер;
    private Timestamp договорДата;
    private Boolean прВнеш;
    private Double ставкаВнешБ;
    private Double ставкаВнешМ;
    private String догФдоНомер;
    private Timestamp догФдоДата;
    private String должнФдо;
    private Boolean прФдо;
    private int id;
    private Collection<RaspEntity> raspList;

    @Basic
    @Column(name = "ПрАрх", nullable = true)
    public Boolean getПрАрх() {
        return прАрх;
    }

    public void setПрАрх(Boolean прАрх) {
        this.прАрх = прАрх;
    }

    @ManyToOne
    @JoinColumn(name = "КодНПР", nullable = true)
    public NprEntity getКодНпр() {
        if (кодНпр==null) {
            кодНпр= new NprEntity();
            кодНпр.setId(11);
            кодНпр.setНаимНпр("БЕЗ НПР");
        }
        return кодНпр;
    }

    public void setКодНпр(NprEntity кодНпр) {
        this.кодНпр = кодНпр;
    }

    @ManyToOne
    @JoinColumn(name = "КодКаф", nullable = true)
    public KafEntity getКодКаф() {
        if (кодКаф==null)
        {
            кодКаф = new KafEntity();
            кодКаф.setКодКаф(0);
        }
        return кодКаф;
    }

    public void setКодКаф(KafEntity кодКаф) {
        this.кодКаф = кодКаф;
    }

    @Basic
    @Column(name = "Фамилия", nullable = true, length = 50)
    public String getФамилия() {
        return фамилия;
    }

    public void setФамилия(String фамилия) {
        this.фамилия = фамилия;
    }

    @Basic
    @Column(name = "Имя", nullable = true, length = 50)
    public String getИмя() {
        return имя;
    }

    public void setИмя(String имя) {
        this.имя = имя;
    }

    @Basic
    @Column(name = "Отчество", nullable = true, length = 50)
    public String getОтчество() {
        return отчество;
    }

    public void setОтчество(String отчество) {
        this.отчество = отчество;
    }

    @Basic
    @Column(name = "ДатаРожд", nullable = true)
    public Timestamp getДатаРожд() {
        return датаРожд;
    }

    public void setДатаРожд(Timestamp датаРожд) {
        this.датаРожд = датаРожд;
    }

    @Basic
    @Column(name = "Пол", nullable = true, length = 1)
    public String getПол() {
        return пол;
    }

    public void setПол(String пол) {
        this.пол = пол;
    }

    @Basic
    @Column(name = "Индекс", nullable = true, length = 50)
    public String getИндекс() {
        return индекс;
    }

    public void setИндекс(String индекс) {
        this.индекс = индекс;
    }

    @Basic
    @Column(name = "Адрес", nullable = true, length = 250)
    public String getАдрес() {
        return адрес;
    }

    public void setАдрес(String адрес) {
        this.адрес = адрес;
    }

    @Basic
    @Column(name = "Почта", nullable = true, length = 50)
    public String getПочта() {
        return почта;
    }

    public void setПочта(String почта) {
        this.почта = почта;
    }

    @Basic
    @Column(name = "Телефон", nullable = true, length = 50)
    public String getТелефон() {
        return телефон;
    }

    public void setТелефон(String телефон) {
        this.телефон = телефон;
    }

    @Basic
    @Column(name = "Серия_П", nullable = true, length = 10)
    public String getСерияП() {
        return серияП;
    }

    public void setСерияП(String серияП) {
        this.серияП = серияП;
    }

    @Basic
    @Column(name = "Номер_П", nullable = true, length = 10)
    public String getНомерП() {
        return номерП;
    }

    public void setНомерП(String номерП) {
        this.номерП = номерП;
    }

    @Basic
    @Column(name = "Паспорт", nullable = true, length = 250)
    public String getПаспорт() {
        return паспорт;
    }

    public void setПаспорт(String паспорт) {
        this.паспорт = паспорт;
    }

    @Basic
    @Column(name = "Образование", nullable = true, length = 255)
    public String getОбразование() {
        return образование;
    }

    public void setОбразование(String образование) {
        this.образование = образование;
    }

    @Basic
    @Column(name = "НаимСтеп", nullable = true, length = 50)
    public String getНаимСтеп() {
        return наимСтеп;
    }

    public void setНаимСтеп(String наимСтеп) {
        this.наимСтеп = наимСтеп;
    }

    @Basic
    @Column(name = "НаимЗван", nullable = true, length = 50)
    public String getНаимЗван() {
        return наимЗван;
    }

    public void setНаимЗван(String наимЗван) {
        this.наимЗван = наимЗван;
    }

    @Basic
    @Column(name = "Должн", nullable = true, length = 50)
    public String getДолжн() {
        return должн;
    }

    public void setДолжн(String должн) {
        this.должн = должн;
    }

    @Basic
    @Column(name = "НаимВнеш", nullable = true, length = 255)
    public String getНаимВнеш() {
        return наимВнеш;
    }

    public void setНаимВнеш(String наимВнеш) {
        this.наимВнеш = наимВнеш;
    }

    @Basic
    @Column(name = "СПС", nullable = true, length = 50)
    public String getСпс() {
        return спс;
    }

    public void setСпс(String спс) {
        this.спс = спс;
    }

    @Basic
    @Column(name = "ИНН", nullable = true, length = 50)
    public String getИнн() {
        return инн;
    }

    public void setИнн(String инн) {
        this.инн = инн;
    }

    @Basic
    @Column(name = "Договор_Номер", nullable = true, length = 255)
    public String getДоговорНомер() {
        return договорНомер;
    }

    public void setДоговорНомер(String договорНомер) {
        this.договорНомер = договорНомер;
    }

    @Basic
    @Column(name = "Договор_Дата", nullable = true)
    public Timestamp getДоговорДата() {
        return договорДата;
    }

    public void setДоговорДата(Timestamp договорДата) {
        this.договорДата = договорДата;
    }

    @Basic
    @Column(name = "ПрВнеш", nullable = true)
    public Boolean getПрВнеш() {
        return прВнеш;
    }

    public void setПрВнеш(Boolean прВнеш) {
        this.прВнеш = прВнеш;
    }

    @Basic
    @Column(name = "Ставка_ВнешБ", nullable = true, precision = 0)
    public Double getСтавкаВнешБ() {
        return ставкаВнешБ;
    }

    public void setСтавкаВнешБ(Double ставкаВнешБ) {
        this.ставкаВнешБ = ставкаВнешБ;
    }

    @Basic
    @Column(name = "Ставка_ВнешМ", nullable = true, precision = 0)
    public Double getСтавкаВнешМ() {
        return ставкаВнешМ;
    }

    public void setСтавкаВнешМ(Double ставкаВнешМ) {
        this.ставкаВнешМ = ставкаВнешМ;
    }

    @Basic
    @Column(name = "ДогФДО_Номер", nullable = true, length = 255)
    public String getДогФдоНомер() {
        return догФдоНомер;
    }

    public void setДогФдоНомер(String догФдоНомер) {
        this.догФдоНомер = догФдоНомер;
    }

    @Basic
    @Column(name = "ДогФДО_Дата", nullable = true)
    public Timestamp getДогФдоДата() {
        return догФдоДата;
    }

    public void setДогФдоДата(Timestamp догФдоДата) {
        this.догФдоДата = догФдоДата;
    }

    @Basic
    @Column(name = "Должн_ФДО", nullable = true, length = 50)
    public String getДолжнФдо() {
        return должнФдо;
    }

    public void setДолжнФдо(String должнФдо) {
        this.должнФдо = должнФдо;
    }

    @Basic
    @Column(name = "ПрФДО", nullable = true)
    public Boolean getПрФдо() {
        return прФдо;
    }

    public void setПрФдо(Boolean прФдо) {
        this.прФдо = прФдо;
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

        PrepsEntity that = (PrepsEntity) o;

        if (id != that.id) return false;
        if (прАрх != null ? !прАрх.equals(that.прАрх) : that.прАрх != null) return false;
        if (кодНпр != null ? !кодНпр.equals(that.кодНпр) : that.кодНпр != null) return false;
        if (кодКаф != null ? !кодКаф.equals(that.кодКаф) : that.кодКаф != null) return false;
        if (фамилия != null ? !фамилия.equals(that.фамилия) : that.фамилия != null) return false;
        if (имя != null ? !имя.equals(that.имя) : that.имя != null) return false;
        if (отчество != null ? !отчество.equals(that.отчество) : that.отчество != null) return false;
        if (датаРожд != null ? !датаРожд.equals(that.датаРожд) : that.датаРожд != null) return false;
        if (пол != null ? !пол.equals(that.пол) : that.пол != null) return false;
        if (индекс != null ? !индекс.equals(that.индекс) : that.индекс != null) return false;
        if (адрес != null ? !адрес.equals(that.адрес) : that.адрес != null) return false;
        if (почта != null ? !почта.equals(that.почта) : that.почта != null) return false;
        if (телефон != null ? !телефон.equals(that.телефон) : that.телефон != null) return false;
        if (серияП != null ? !серияП.equals(that.серияП) : that.серияП != null) return false;
        if (номерП != null ? !номерП.equals(that.номерП) : that.номерП != null) return false;
        if (паспорт != null ? !паспорт.equals(that.паспорт) : that.паспорт != null) return false;
        if (образование != null ? !образование.equals(that.образование) : that.образование != null) return false;
        if (наимСтеп != null ? !наимСтеп.equals(that.наимСтеп) : that.наимСтеп != null) return false;
        if (наимЗван != null ? !наимЗван.equals(that.наимЗван) : that.наимЗван != null) return false;
        if (должн != null ? !должн.equals(that.должн) : that.должн != null) return false;
        if (наимВнеш != null ? !наимВнеш.equals(that.наимВнеш) : that.наимВнеш != null) return false;
        if (спс != null ? !спс.equals(that.спс) : that.спс != null) return false;
        if (инн != null ? !инн.equals(that.инн) : that.инн != null) return false;
        if (договорНомер != null ? !договорНомер.equals(that.договорНомер) : that.договорНомер != null) return false;
        if (договорДата != null ? !договорДата.equals(that.договорДата) : that.договорДата != null) return false;
        if (прВнеш != null ? !прВнеш.equals(that.прВнеш) : that.прВнеш != null) return false;
        if (ставкаВнешБ != null ? !ставкаВнешБ.equals(that.ставкаВнешБ) : that.ставкаВнешБ != null) return false;
        if (ставкаВнешМ != null ? !ставкаВнешМ.equals(that.ставкаВнешМ) : that.ставкаВнешМ != null) return false;
        if (догФдоНомер != null ? !догФдоНомер.equals(that.догФдоНомер) : that.догФдоНомер != null) return false;
        if (догФдоДата != null ? !догФдоДата.equals(that.догФдоДата) : that.догФдоДата != null) return false;
        if (должнФдо != null ? !должнФдо.equals(that.должнФдо) : that.должнФдо != null) return false;
        if (прФдо != null ? !прФдо.equals(that.прФдо) : that.прФдо != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = прАрх != null ? прАрх.hashCode() : 0;
        result = 31 * result + (кодНпр != null ? кодНпр.hashCode() : 0);
        result = 31 * result + (кодКаф != null ? кодКаф.hashCode() : 0);
        result = 31 * result + (фамилия != null ? фамилия.hashCode() : 0);
        result = 31 * result + (имя != null ? имя.hashCode() : 0);
        result = 31 * result + (отчество != null ? отчество.hashCode() : 0);
        result = 31 * result + (датаРожд != null ? датаРожд.hashCode() : 0);
        result = 31 * result + (пол != null ? пол.hashCode() : 0);
        result = 31 * result + (индекс != null ? индекс.hashCode() : 0);
        result = 31 * result + (адрес != null ? адрес.hashCode() : 0);
        result = 31 * result + (почта != null ? почта.hashCode() : 0);
        result = 31 * result + (телефон != null ? телефон.hashCode() : 0);
        result = 31 * result + (серияП != null ? серияП.hashCode() : 0);
        result = 31 * result + (номерП != null ? номерП.hashCode() : 0);
        result = 31 * result + (паспорт != null ? паспорт.hashCode() : 0);
        result = 31 * result + (образование != null ? образование.hashCode() : 0);
        result = 31 * result + (наимСтеп != null ? наимСтеп.hashCode() : 0);
        result = 31 * result + (наимЗван != null ? наимЗван.hashCode() : 0);
        result = 31 * result + (должн != null ? должн.hashCode() : 0);
        result = 31 * result + (наимВнеш != null ? наимВнеш.hashCode() : 0);
        result = 31 * result + (спс != null ? спс.hashCode() : 0);
        result = 31 * result + (инн != null ? инн.hashCode() : 0);
        result = 31 * result + (договорНомер != null ? договорНомер.hashCode() : 0);
        result = 31 * result + (договорДата != null ? договорДата.hashCode() : 0);
        result = 31 * result + (прВнеш != null ? прВнеш.hashCode() : 0);
        result = 31 * result + (ставкаВнешБ != null ? ставкаВнешБ.hashCode() : 0);
        result = 31 * result + (ставкаВнешМ != null ? ставкаВнешМ.hashCode() : 0);
        result = 31 * result + (догФдоНомер != null ? догФдоНомер.hashCode() : 0);
        result = 31 * result + (догФдоДата != null ? догФдоДата.hashCode() : 0);
        result = 31 * result + (должнФдо != null ? должнФдо.hashCode() : 0);
        result = 31 * result + (прФдо != null ? прФдо.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return фамилия+" "+имя+" "+отчество;
    }

    @OneToMany(mappedBy = "кодПреп",orphanRemoval = true)
    public Collection<RaspEntity> getRaspList() {
        return raspList;
    }

    public void setRaspList(Collection<RaspEntity> raspList) {
        this.raspList = raspList;
    }

    private Collection<NagrEntity> nagrList;

    @OneToMany(mappedBy = "prepsByКодПреп",fetch = FetchType.EAGER)
    public Collection<NagrEntity> getNagrList() {
        return nagrList;
    }

    public void setNagrList(Collection<NagrEntity> nagrList) {
        this.nagrList = nagrList;
    }
}
