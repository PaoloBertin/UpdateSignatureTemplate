package eu.opensource.updateSignatureTemplate.service;

import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplatePayload;
import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplateRequest;
import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplateResponse;
import eu.opensource.updateSignatureTemplate.domain.SignatureTemplate;
import eu.opensource.updateSignatureTemplate.repository.SignatureTemplateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Service
public class SignatureTemplateServiceImpl implements SignatureTemplateService {

    @Autowired
    private SignatureTemplateRepository signatureTemplateRepository;

    @Override
    public SignatureTemplateResponse createSignateTemplate(SignatureTemplateRequest request) {

        SignatureTemplatePayload signatureTemplatePayload = request.getSignatureTemplatePayload();


        SignatureTemplate signatureTemplate = new SignatureTemplate();
        signatureTemplate = signatureTemplateRepository.save(signatureTemplate);
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public SignatureTemplateResponse getSignatureTemplate(SignatureTemplateRequest request) {

        Long signatureTemplateId = request.getSignatureTemplatePayload().getId();
        SignatureTemplate signatureTemplate = signatureTemplateRepository.findById(signatureTemplateId).orElseThrow();

        SignatureTemplatePayload signatureTemplatePayload = new SignatureTemplatePayload();
        signatureTemplatePayload.setId(signatureTemplate.getId());
        signatureTemplatePayload.setSignaturaTemplateName(signatureTemplate.getSignaturaTemplateName());
        signatureTemplatePayload.setDefault(signatureTemplate.getDefault());
        signatureTemplatePayload.setDocumentClassFolder_id(signatureTemplate.getDocumentClassFolder().getId());
        signatureTemplatePayload.setTpSignatureTemplate_id(signatureTemplate.getTpSignatureTemplate().getId());
        SignatureTemplateResponse response = new SignatureTemplateResponse();
        response.setSignatureTemplatePayload(signatureTemplatePayload);

        return response;
    }

    @Transactional(readOnly = true)
    @Override
    public SignatureTemplateResponse getAllSignatureTemplates(SignatureTemplateRequest request) {

        List<SignatureTemplate> signatureTemplates = signatureTemplateRepository.findAll();


        return null;
    }

    @Override
    public SignatureTemplateResponse updateSignatureTemplate(SignatureTemplateRequest request) {

        return null;
    }

    @Override
    public SignatureTemplateResponse deleteSignatureTemplate(SignatureTemplateRequest request) {

        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public SignatureTemplateResponse changeDefaultSignatureTemplate(SignatureTemplateRequest request) {


        // modifica signatureTemplate di default
        log.debug("");
        Long defaultSignatureTemplateId = request.getSignatureTemplatePayload().getId();
        int numberOfUpdatedRecord = signatureTemplateRepository.setDefaultForDocumentClass(defaultSignatureTemplateId);
        log.debug("numberOfUpdatedRecord=" + numberOfUpdatedRecord);

        // costruzione signatureTemplateResponse
        SignatureTemplateResponse signatureTemplateResponse = new SignatureTemplateResponse();
        signatureTemplateResponse.setSignatureTemplatePayload(new SignatureTemplatePayload());

        return signatureTemplateResponse;
    }
}
