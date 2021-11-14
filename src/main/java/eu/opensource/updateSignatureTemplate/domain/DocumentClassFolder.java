package eu.opensource.updateSignatureTemplate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Table(name = "document_class_folder")
@Entity
public class DocumentClassFolder implements Serializable {

    private static final long serialVersionUID = 1872922983154704295L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_class_folder_name")
    private String documentClassFolderName;

    @OneToMany(mappedBy = "documentClassFolder", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SignatureTemplate> signatureTemplates;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getDocumentClassFolderName() {

        return documentClassFolderName;
    }

    public void setDocumentClassFolderName(String documentClassFolderName) {

        this.documentClassFolderName = documentClassFolderName;
    }

    public Set<SignatureTemplate> getSignatureTemplates() {

        return signatureTemplates;
    }

    public void setSignatureTemplates(Set<SignatureTemplate> signatureTemplates) {

        this.signatureTemplates = signatureTemplates;
    }
}
