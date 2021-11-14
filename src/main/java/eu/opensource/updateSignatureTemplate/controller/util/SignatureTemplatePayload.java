package eu.opensource.updateSignatureTemplate.controller.util;

public class SignatureTemplatePayload {

    private Long id;

    private String signaturaTemplateName;

    private Boolean isDefault;

    private Long documentClassFolder_id;

    private Long tpSignatureTemplate_id;

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

    public Long getDocumentClassFolder_id() {

        return documentClassFolder_id;
    }

    public void setDocumentClassFolder_id(Long documentClassFolder_id) {

        this.documentClassFolder_id = documentClassFolder_id;
    }

    public Long getTpSignatureTemplate_id() {

        return tpSignatureTemplate_id;
    }

    public void setTpSignatureTemplate_id(Long tpSignatureTemplate_id) {

        this.tpSignatureTemplate_id = tpSignatureTemplate_id;
    }
}
