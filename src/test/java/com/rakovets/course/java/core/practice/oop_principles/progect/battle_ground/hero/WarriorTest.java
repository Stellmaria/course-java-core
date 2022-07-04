package com.rakovets.course.java.core.practice.oop_principles.progect.battle_ground.hero;

import com.rakovets.course.java.core.practice.oop_principles.progect.battle_ground.enemy.Enemy;
import com.rakovets.course.java.core.practice.oop_principles.progect.battle_ground.enemy.Vampire;
import com.rakovets.course.java.core.practice.oop_principles.progect.battle_ground.enemy.Werewolf;
import com.rakovets.course.java.core.practice.oop_principles.progect.battle_ground.enemy.Zombie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class WarriorTest {
    Warrior warrior = new Warrior("", 0);
    Vampire vampire = new Vampire(0);
    Werewolf werewolf = new Werewolf(0, 0);
    Zombie zombie = new Zombie(0);
    Enemy enemy = new Enemy(0) {
        @Override
        protected void attackEnemy(Hero hero) {
        }
    };

    static Stream<Arguments> warriorIsAliveProviderArguments() {
        return Stream.of(
                Arguments.of(100, true),
                Arguments.of(0, false),
                Arguments.of(50, true)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorIsAliveProviderArguments")
    void warriorIsAlive(int health, boolean expected) {
        warrior.setHealth(health);

        boolean actual = warrior.isAlive();

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorTakingDamageProviderArguments() {
        return Stream.of(
                Arguments.of(100, 80, 30),
                Arguments.of(0, 10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorTakingDamageProviderArguments")
    void warriorTakingDamage(int health, int damage, int expected) {
        warrior.setHealth(health);

        int actual = warrior.takingDamage(damage);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorTakingDamageByAVampireProviderArguments() {
        return Stream.of(
                Arguments.of(100, 85),
                Arguments.of(0, 0),
                Arguments.of(25, 0),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorTakingDamageByAVampireProviderArguments")
    void warriorTakingDamageByAVampire(int health, int expected) {
        warrior.setHealth(health);

        int actual = warrior.takingDamage(vampire.getDAMAGE_VAMPIRE());

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorTakingDamageByAWerewolfDayProviderArguments() {
        return Stream.of(
                Arguments.of(100, 90),
                Arguments.of(0, 0),
                Arguments.of(20, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorTakingDamageByAWerewolfDayProviderArguments")
    void warriorTakingDamageByAWerewolfDay(int health, int expected) {
        warrior.setHealth(health);

        int actual = warrior.takingDamage(werewolf.getDAMAGE_WEREWOLF());

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorTakingDamageByAWerewolfNightProviderArguments() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(50, 20),
                Arguments.of(25, 0),
                Arguments.of(10, 0),
                Arguments.of(40, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorTakingDamageByAWerewolfNightProviderArguments")
    void warriorTakingDamageByAWerewolfNight(int health, int expected) {
        warrior.setHealth(health);

        int actual = warrior.takingDamage(werewolf.getDAMAGE_WEREWOLF_NIGHT());

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorTakingDamageByAZombieProviderArguments() {
        return Stream.of(
                Arguments.of(100, 98),
                Arguments.of(0, 0),
                Arguments.of(12, 0),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorTakingDamageByAZombieProviderArguments")
    void warriorTakingDamageByAZombie(int health, int expected) {
        warrior.setHealth(health);

        int actual = warrior.takingDamage(zombie.getDAMAGE_ZOMBIE());

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorAttackEnemyProvideArguments() {
        return Stream.of(
                Arguments.of(100, 76),
                Arguments.of(50, 26),
                Arguments.of(0, 0),
                Arguments.of(20, 0),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorAttackEnemyProvideArguments")
    void archerAttackEnemy(int health, int expected) {
        enemy.setHealth(health);

        warrior.attackEnemy(enemy);
        int actual = enemy.getHealth();

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorAttackVampireProvideArguments() {
        return Stream.of(
                Arguments.of(100, 91),
                Arguments.of(50, 41),
                Arguments.of(0, 0),
                Arguments.of(4, 0),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorAttackVampireProvideArguments")
    void warriorAttackVampire(int health, int expected) {
        vampire.setHealth(health);

        warrior.attackEnemy(vampire);
        int actual = vampire.getHealth();

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorAttackWerewolfProvideArguments() {
        return Stream.of(
                Arguments.of(100, 76),
                Arguments.of(50, 26),
                Arguments.of(0, 0),
                Arguments.of(20, 0),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorAttackWerewolfProvideArguments")
    void warriorAttackWerewolf(int health, int expected) {
        werewolf.setHealth(health);

        warrior.attackEnemy(werewolf);
        int actual = werewolf.getHealth();

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> warriorAttackZombieProvideArguments() {
        return Stream.of(
                Arguments.of(100, 76),
                Arguments.of(50, 26),
                Arguments.of(0, 0),
                Arguments.of(20, 0),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("warriorAttackZombieProvideArguments")
    void warriorAttackZombie(int health, int expected) {
        zombie.setHealth(health);

        warrior.attackEnemy(zombie);
        int actual = zombie.getHealth();

        Assertions.assertEquals(expected, actual);
    }
}
