INSERT INTO USUARIO (id, nome, email, senha, telefone, cpf, nascimento, role, cadastro, atualizacao, status) VALUES
(RANDOM_UUID(),'João Silva'    ,'joao.silva@gmail.com'    ,'$2a$10$JIadr98bw3UwfbSDW2mkU.BwqS2utVmTetX2/K6d3AYZUF/ldwYqK','(95) 3769-8998' , '353.304.567-62', '1990-05-15', 'ROLE_ADMIN',NOW(),NOW(), 'S'),
(RANDOM_UUID(),'Maria Oliveira','maria.oliveira@gmail.com','$2a$10$JIadr98bw3UwfbSDW2mkU.BwqS2utVmTetX2/K6d3AYZUF/ldwYqK','(95) 99711-9066', '094.463.035-91', '1985-08-22', 'ROLE_USER' ,NOW(),NOW(), 'S'),
(RANDOM_UUID(),'Carlos Pereira','carlos.pereira@gmail.com','$2a$10$JIadr98bw3UwfbSDW2mkU.BwqS2utVmTetX2/K6d3AYZUF/ldwYqK','(21) 2769-8274' , '094.463.036-91', '1982-12-30', 'ROLE_USER' ,NOW(),NOW(), 'S'),
(RANDOM_UUID(),'Ana Costa'     ,'ana.costa@gmail.com'     ,'$2a$10$JIadr98bw3UwfbSDW2mkU.BwqS2utVmTetX2/K6d3AYZUF/ldwYqK','(21) 99543-6384', '366.041.258-90', '1982-12-30', 'ROLE_USER' ,NOW(),NOW(), 'S');
