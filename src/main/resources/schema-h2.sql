DROP TABLE IF EXISTS signature_template;
DROP TABLE IF EXISTS document_class_folder;
DROP TABLE IF EXISTS tp_signature_template;

CREATE TABLE IF NOT EXISTS document_class_folder (
    id BIGINT NOT NULL AUTO_INCREMENT,
    document_class_folder_name VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS tp_signature_template (
    id BIGINT NOT NULL AUTO_INCREMENT,
    tp_signature_template_name VARCHAR(255) NOT NULL,

    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS signature_template (
    id BIGINT NOT NULL AUTO_INCREMENT,
    signature_template_name VARCHAR(255) NOT NULL,
    is_default BOOLEAN NOT NULL,
    document_class_folder_id BIGINT,
    tp_signature_template_id BIGINT,

    PRIMARY KEY(id),

    CONSTRAINT signature_template_fk_01 FOREIGN KEY (document_class_folder_id) REFERENCES document_class_folder(id),
    CONSTRAINT signature_template_fk_02 FOREIGN KEY (tp_signature_template_id) REFERENCES tp_signature_template(id)
);
