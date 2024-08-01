INSERT INTO architecture (name) VALUES ('Ampere'), ('Turing'), ('Pascal');
INSERT INTO cpu (name, generation) VALUES ('Intel i5', 9), ('AMD Ryzen 7', 3), ('Intel i7', 10), ('AMD Ryzen 5', 4), ('Intel i9', 11);
INSERT INTO gpu (name, price, release_date, available, architecture_id) VALUES ('Nvidia Gtx 1070', 1099, '2015-10-10', false, 1), ('Nvidia RTX 3080', 1499, '2020-09-17', true, 1), ('AMD Radeon RX 5700', 899, '2019-07-07', true, 2), ('Nvidia Gtx 1660', 249, '2019-03-14', true, 3), ('AMD Radeon RX 580', 299, '2017-04-18', true, 2);
INSERT INTO bonus_game_code (code, gpu_id) VALUES ('adwerrerr', 1), ('rewgttrbs', 2), ('trwooopa', 3), ('aserthdwp', 4), ('lpgrtvagd 5', 5);

 INSERT INTO gpu_cpus (cpus_id, gpus_id) VALUES (1, 1), (1, 2), (2, 1), (2, 3), (3, 2), (3, 4), (4, 3), (4, 5), (5, 4), (5, 5);
