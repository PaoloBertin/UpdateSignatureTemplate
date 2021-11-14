INSERT INTO document_class_folder(id, document_class_folder_name)
    VALUES(1, 'Protocollo Ingresso'),
          (2, 'Protocollo Interno'),
          (3, 'Protocollo Uscita'),
          (4, 'Registro di Protocollo')
    ;

INSERT INTO tp_signature_template(id, tp_signature_template_name)
    VALUES(1, 'Protocollo Informatico'),
          (2, 'Protocollo Analogico')
    ;

INSERT INTO signature_template(id, signature_template_name, is_default, document_class_folder_id, tp_signature_template_id)
    VALUES(1, 'RD_RegistroProtocollo_ProtocolloInformatico1',  TRUE, 4, 1),
          (2, 'RD_RegistroProtocollo_ProtocolloAnalogico1',   FALSE, 4, 2),
          (3, 'RD_RegistroProtocollo_ProtocolloInformatico2', FALSE, 4, 1),
          (4, 'RD_RegistroProtocollo_ProtocolloInformatico3', FALSE, 4, 1),
          (5, 'RD_RegistroProtocollo_ProtocolloAnalogico',    FALSE, 4, 2)
    ;
