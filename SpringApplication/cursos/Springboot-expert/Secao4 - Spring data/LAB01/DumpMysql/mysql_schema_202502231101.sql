CREATE TABLE mediatype (
    media_type_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (media_type_id)
);

CREATE TABLE playlist (
    playlist_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (playlist_id)
);

CREATE TABLE genre (
    genre_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (genre_id)
);

CREATE TABLE artist (
    artist_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (artist_id)
);

CREATE TABLE album (
    album_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(160) NOT NULL,
    artist_id INT NOT NULL,
    PRIMARY KEY (album_id),
    FOREIGN KEY (artist_id) REFERENCES artist(artist_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE employee (
    employee_id INT NOT NULL AUTO_INCREMENT,
    last_name VARCHAR(20) NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    title VARCHAR(30),
    reports_to INT,
    birth_date DATETIME,
    hire_date DATETIME,
    address VARCHAR(70),
    city VARCHAR(40),
    state VARCHAR(40),
    country VARCHAR(40),
    postal_code VARCHAR(10),
    phone VARCHAR(24),
    fax VARCHAR(24),
    email VARCHAR(60),
    PRIMARY KEY (employee_id),
    FOREIGN KEY (reports_to) REFERENCES employee(employee_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE customer (
    customer_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(40) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    company VARCHAR(80),
    address VARCHAR(70),
    city VARCHAR(40),
    state VARCHAR(40),
    country VARCHAR(40),
    postal_code VARCHAR(10),
    phone VARCHAR(24),
    fax VARCHAR(24),
    email VARCHAR(60) NOT NULL,
    support_rep_id INT,
    PRIMARY KEY (customer_id),
    FOREIGN KEY (support_rep_id) REFERENCES employee(employee_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE invoice (
    invoice_id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    invoice_date DATETIME NOT NULL,
    billing_address VARCHAR(70),
    billing_city VARCHAR(40),
    billing_state VARCHAR(40),
    billing_country VARCHAR(40),
    billing_postal_code VARCHAR(10),
    total DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (invoice_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE track (
    track_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    album_id INT,
    media_type_id INT NOT NULL,
    genre_id INT,
    composer VARCHAR(220),
    milliseconds INT NOT NULL,
    bytes INT,
    unit_price DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (track_id),
    FOREIGN KEY (album_id) REFERENCES album(album_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (media_type_id) REFERENCES mediatype(media_type_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);



CREATE TABLE invoiceline (
    invoice_line_id INT NOT NULL AUTO_INCREMENT,
    invoice_id INT NOT NULL,
    track_id INT NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (invoice_line_id),
    FOREIGN KEY (invoice_id) REFERENCES invoice(invoice_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (track_id) REFERENCES track(track_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE playlisttrack (
    playlist_id INT NOT NULL,
    track_id INT NOT NULL,
    PRIMARY KEY (playlist_id, track_id),
    FOREIGN KEY (playlist_id) REFERENCES playlist(playlist_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (track_id) REFERENCES track(track_id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE INDEX IFK_AlbumArtistId ON album (artist_id);
CREATE INDEX IFK_CustomerSupportRepId ON customer (support_rep_id);
CREATE INDEX IFK_EmployeeReportsTo ON employee (reports_to);
CREATE INDEX IFK_InvoiceCustomerId ON invoice (customer_id);
CREATE INDEX IFK_InvoiceLineInvoiceId ON invoiceline (invoice_id);
CREATE INDEX IFK_InvoiceLineTrackId ON invoiceline (track_id);
CREATE INDEX IFK_PlaylistTrackTrackId ON playlisttrack (track_id);
CREATE INDEX IFK_TrackAlbumId ON track (album_id);
CREATE INDEX IFK_TrackGenreId ON track (genre_id);
CREATE INDEX IFK_TrackMediaTypeId ON track (media_type_id);
