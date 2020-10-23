-- Pronunciation Schema

-- !Ups

INSERT INTO WordGroups (root_spelling) VALUES
       ('ba'),
       ('bi'),
       ('bo'),
       ('đo'),
       ('đu'),
       ('lân'),
       ('ma'),
       ('man'),
       ('me'),
       ('mo'),
       ('tân'),
       ('trô'),
       ('va'),
       ('vai'),
       ('vang'),
       ('vây'),
       ('vi'),
       ('vo');

INSERT INTO Words (spelling, tone, word_group) VALUES
('ba', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'ba')),
('bá', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'ba')),
('bà', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'ba')),
('bạ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'ba')),
('bã', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'ba')),
('bả', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'ba')),
('bi', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'bi')),
('bí', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'bi')),
('bì', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'bi')),
('bị', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'bi')),
('bĩ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'bi')),
('bỉ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'bi')),
('bo', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'bo')),
('bó', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'bo')),
('bò', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'bo')),
('bọ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'bo')),
('bõ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'bo')),
('bỏ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'bo')),
('đo', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'đo')),
('đó', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'đo')),
('đò', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'đo')),
('đọ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'đo')),
('đõ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'đo')),
('đỏ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'đo')),
('đu', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'đu')),
('đú', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'đu')),
('đù', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'đu')),
('đụ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'đu')),
('đũ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'đu')),
('đủ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'đu')),
('lân', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'lân')),
('lấn', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'lân')),
('lần', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'lân')),
('lận', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'lân')),
('lẫn', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'lân')),
('lẩn', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'lân')),
('ma', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'ma')),
('má', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'ma')),
('mà', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'ma')),
('mạ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'ma')),
('mã', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'ma')),
('mả', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'ma')),
('man', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'man')),
('mán', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'man')),
('màn', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'man')),
('mạn', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'man')),
('mãn', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'man')),
('mản', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'man')),
('me', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'me')),
('mé', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'me')),
('mè', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'me')),
('mẹ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'me')),
('mẽ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'me')),
('mẻ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'me')),
('mo', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'mo')),
('mó', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'mo')),
('mò', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'mo')),
('mọ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'mo')),
('mõ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'mo')),
('mỏ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'mo')),
('tân', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'tân')),
('tấn', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'tân')),
('tần', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'tân')),
('tận', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'tân')),
('tẫn', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'tân')),
('tẩn', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'tân')),
('trô', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'trô')),
('trố', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'trô')),
('trồ', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'trô')),
('trộ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'trô')),
('trỗ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'trô')),
('trổ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'trô')),
('va', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'va')),
('vá', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'va')),
('và', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'va')),
('vạ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'va')),
('vã', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'va')),
('vả', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'va')),
('vai', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'vai')),
('vái', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'vai')),
('vài', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'vai')),
('vại', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'vai')),
('vãi', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'vai')),
('vải', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'vai')),
('vang', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'vang')),
('váng', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'vang')),
('vàng', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'vang')),
('vạng', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'vang')),
('vãng', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'vang')),
('vảng', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'vang')),
('vây', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'vây')),
('vấy', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'vây')),
('vầy', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'vây')),
('vậy', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'vây')),
('vẫy', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'vây')),
('vẩy', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'vây')),
('vi', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'vi')),
('ví', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'vi')),
('vì', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'vi')),
('vị', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'vi')),
('vĩ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'vi')),
('vỉ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'vi')),
('vo', 'ngang', (SELECT id FROM WordGroups WHERE root_spelling = 'vo')),
('vó', 'sac', (SELECT id FROM WordGroups WHERE root_spelling = 'vo')),
('vò', 'huyen', (SELECT id FROM WordGroups WHERE root_spelling = 'vo')),
('vọ', 'nang', (SELECT id FROM WordGroups WHERE root_spelling = 'vo')),
('võ', 'nga', (SELECT id FROM WordGroups WHERE root_spelling = 'vo')),
('vỏ', 'hoi', (SELECT id FROM WordGroups WHERE root_spelling = 'vo'));

-- !Downs

DELETE FROM WordGroups WHERE
       root_spelling = 'ba' OR
       root_spelling = 'bo' OR
       root_spelling = 'bi' OR
       root_spelling = 'đo' OR
       root_spelling = 'đu' OR
       root_spelling = 'lân' OR
       root_spelling = 'ma' OR
       root_spelling = 'man' OR
       root_spelling = 'mo' OR
       root_spelling = 'me' OR
       root_spelling = 'tân' OR
       root_spelling = 'trô' OR
       root_spelling = 'va' OR
       root_spelling = 'vai' OR
       root_spelling = 'vang' OR
       root_spelling = 'vây' OR
       root_spelling = 'vi' OR
       root_spelling = 'vo' CASCADE;
