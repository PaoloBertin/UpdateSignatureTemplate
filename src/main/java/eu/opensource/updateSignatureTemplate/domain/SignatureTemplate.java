package eu.opensource.updateSignatureTemplate.domain;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "signature_template")
@Entity
public class SignatureTemplate implements Serializable {

    private static final long serialVersionUID = 4708248154577412656L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "signature_template_name")
    private String signaturaTemplateName;

    @Column(name = "is_default")
    private Boolean isDefault;

    @JoinColumn(name = "document_class_folder_id", foreignKey = @ForeignKey(name = "signature_template_fk_01"))
    @ManyToOne
    private DocumentClassFolder documentClassFolder;

    @JoinColumn(name = "tp_signature_template_id", foreignKey = @ForeignKey(name = "signature_template_fk_02"))
    @ManyToOne
    private TpSignatureTemplate tpSignatureTemplate;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getSignaturaTemplateName() {

        return signaturaTemplateName;
    }

    public void setSignaturaTemplateName(String signaturaTemplateName) {

        this.signaturaTemplateName = signaturaTemplateName;
    }

    public Boolean getDefault() {

        return isDefault;
    }

    public void setDefault(Boolean aDefault) {

        isDefault = aDefault;
    }

    public DocumentClassFolder getDocumentClassFolder() {

        return documentClassFolder;
    }

    public void setDocumentClassFolder(DocumentClassFolder documentClassFolder) {

        this.documentClassFolder = documentClassFolder;
    }

    public TpSignatureTemplate getTpSignatureTemplate() {

        return tpSignatureTemplate;
    }

    public void setTpSignatureTemplate(TpSignatureTemplate tpSignatureTemplate) {

        this.tpSignatureTemplate = tpSignatureTemplate;
    }

    @Override
    public String toString() {

        return "SignatureTemplate{" +
                "id=" + id +
                ", signaturaTemplateName='" + signaturaTemplateName + '\'' +
                ", isDefault=" + isDefault +
                ", documentClassFolder_id=" + documentClassFolder.getId() +
                ", tpSignatureTemplate_id=" + tpSignatureTemplate.getId() +
                '}';
    }
}
