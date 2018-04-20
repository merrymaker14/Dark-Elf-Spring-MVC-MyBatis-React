CREATE
	TABLE
		 users(
			id INTEGER NOT NULL PRIMARY KEY,
			login VARCHAR(40) NOT NULL,
			password VARCHAR(255) NOT NULL,
			isAdmin BOOLEAN NOT NULL
		);


		INSERT INTO users (id, login, password, isAdmin) VALUES (1,'admin','001',TRUE);
		INSERT INTO users (id, login, password, isAdmin) VALUES (2,'user','002',FALSE);