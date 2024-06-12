INSERT INTO SPORTS (name, team_size, rounds, status) VALUES
('HandBall', 11, 2, true);

INSERT INTO AWARDS (competition, place) VALUES
('World Championship', 'first place');

INSERT INTO COMPETITIONS (name, stage_count ,date_start, date_end) VALUES
('World Championship', 4, '2024-12-30', '2025-12-30');

INSERT INTO STAGES (stage_type, winner) VALUES
('FINALS', 'Boca Juniors');

INSERT INTO MATCHES (start_at, end_at, points_team_a, points_team_b) VALUES
(null, null, 15, 20);

--INSERT INTO ADMINS (email, password, role, is_present, name) VALUES
--('nico@gmail.com','123456', 'ADMIN', true, 'Nicolas');
--
--INSERT INTO PLAYERS (email, password, role, is_present, name, phone, contact_email) VALUES
--('ariel@gmail.com','987654', 'PLAYER', true, 'Ariel', '117875637', 'ariel@outlook.com');
--
INSERT INTO TEAM_MANAGERS (email, password, is_present, name) VALUES
('dalmiro@gmail.com','10293847', true, 'Dalmiro');

INSERT INTO IMAGES_ENTITIES (url, image_id, image_name) VALUES
('url1', '12', 'imagen');
