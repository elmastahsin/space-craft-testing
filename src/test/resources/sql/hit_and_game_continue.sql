INSERT INTO game(id, boost, is_ended, is_win, level)
VALUES (1, 'BIG_BOMB', false, false, 'EASY');

INSERT INTO player(id, armor, health, shoot_power, username, game_id)
VALUES (1, 50, 2000, 300, 'USERNAME', 1);

INSERT INTO target(id, armor, health, shoot_power, game_id)
VALUES
    (1, 7, 1500, 150, 1);