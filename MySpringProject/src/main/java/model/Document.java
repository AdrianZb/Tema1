package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by azburatura on 8/4/2016.
 */
@Entity
@Table(name = "document")
public class Document extends BaseEntity {

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "file_path")
    private String filePath;

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "Document{" +
                "denumire='" + denumire + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
