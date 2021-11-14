package eu.opensource.updateSignatureTemplate.controller;

import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplatePayload;
import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplateRequest;
import eu.opensource.updateSignatureTemplate.controller.util.SignatureTemplateResponse;
import eu.opensource.updateSignatureTemplate.service.SignatureTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/signatureTemplate")
@RestController
public class SignatureTemplateController {

    @Autowired
    private SignatureTemplateService signatureTemplateService;

    @GetMapping("/create")
    public ResponseEntity<SignatureTemplateResponse> createSignatureTemplate(@RequestBody SignatureTemplateRequest request) {

        SignatureTemplateResponse signatureTemplateResponse = signatureTemplateService.createSignateTemplate(request);

        ResponseEntity<SignatureTemplateResponse> response = new ResponseEntity(signatureTemplateResponse, HttpStatus.OK);
        return response;
    }

    @GetMapping("/get")
    public ResponseEntity<SignatureTemplateResponse> getSignatureTemplate(@RequestBody SignatureTemplateRequest request) {

        SignatureTemplateResponse signatureTemplateResponse = signatureTemplateService.getSignatureTemplate(request);

        ResponseEntity<SignatureTemplateResponse> response = new ResponseEntity(signatureTemplateResponse, HttpStatus.OK);
        return response;
    }

    @GetMapping("/getAll")
    public ResponseEntity<SignatureTemplateResponse> getAllSignatureTemplates(@RequestBody SignatureTemplateRequest request) {

        SignatureTemplateResponse signatureTemplateResponse = signatureTemplateService.getAllSignatureTemplates(request);

        ResponseEntity<SignatureTemplateResponse> response = new ResponseEntity(signatureTemplateResponse, HttpStatus.OK);

        return response;
    }

    @GetMapping("/update")
    public ResponseEntity<SignatureTemplateResponse> updateSignatureTemplate(@RequestBody SignatureTemplateRequest request) {

        SignatureTemplateResponse signatureTemplateResponse = signatureTemplateService.updateSignatureTemplate(request);

        ResponseEntity<SignatureTemplateResponse> response = new ResponseEntity(signatureTemplateResponse, HttpStatus.OK);
        return response;
    }

    @GetMapping("/delete")
    public ResponseEntity<SignatureTemplateResponse> deleteSignatureTemplate(@RequestBody SignatureTemplateRequest request) {

        SignatureTemplateResponse signatureTemplateResponse = signatureTemplateService.deleteSignatureTemplate(request);

        ResponseEntity<SignatureTemplateResponse> response = new ResponseEntity(signatureTemplateResponse, HttpStatus.OK);
        return response;
    }

    @GetMapping("/isDefault")
    public ResponseEntity<SignatureTemplateResponse> setIsDefault(@RequestBody SignatureTemplateRequest request) {

//        logSignatureTemplate(request.getSignatureTemplatePayload().getId());

        signatureTemplateService.changeDefaultSignatureTemplate(request);
        SignatureTemplateResponse signatureTemplateResponse = signatureTemplateService.getSignatureTemplate(request);

//        logSignatureTemplate(request.getSignatureTemplatePayload().getId());

        ResponseEntity<SignatureTemplateResponse> response = new ResponseEntity(signatureTemplateResponse, HttpStatus.OK);
        return response;
    }

    private void logSignatureTemplate(Long defaultSignatureTemplateId) {

        // recupera id signatureTemplate
        log.debug("SignatureTemplate");
        log.debug("defaultSignatureTemplateId = " + defaultSignatureTemplateId);

        // legge signatureTemplate che si vuol rendere di default
        SignatureTemplateRequest request = new SignatureTemplateRequest();
        SignatureTemplatePayload signatureTemplatePayload = new SignatureTemplatePayload();
        signatureTemplatePayload.setId(defaultSignatureTemplateId);
        request.setSignatureTemplatePayload(signatureTemplatePayload);
        SignatureTemplateResponse signatureTemplateResponse = signatureTemplateService.getSignatureTemplate(request);

        // visualizza signatureTemplate che si vuol rendere default
        signatureTemplatePayload = signatureTemplateResponse.getSignatureTemplatePayload();
        log.debug("signatureTemplateId = " + signatureTemplatePayload.getId());
        log.debug("signatureTemplatName = " + signatureTemplatePayload.getSignaturaTemplateName());
        log.debug("idDefault = " +  signatureTemplatePayload.getDefault());
        log.debug("documentClassFolder_id = " + signatureTemplatePayload.getDocumentClassFolder_id());
        log.debug("tpSignatureTemplate_id =" + signatureTemplatePayload.getTpSignatureTemplate_id());
    }
}
