package com.noobs2d.smashsmash.alien;

import java.util.ArrayList;

import com.noobs2d.smashsmash.screen.SmashSmashStageCallback;
import com.noobs2d.tweenengine.utils.DynamicAnimation;
import com.noobs2d.tweenengine.utils.DynamicDisplay;
import com.noobs2d.tweenengine.utils.DynamicDisplay.DynamicRegistration;
import com.noobs2d.tweenengine.utils.DynamicDisplayGroup;

public class Tortoise extends Alien {

    public Tortoise(SmashSmashStageCallback stage) {
	super.stage = stage;
	initAttackingState();
	initHidingState();
	initRisingState();
	initSmashedState();
	initStunnedState();
	initWaitingState();
    }

    @Override
    public int getScore() {
	return state == AlienState.RISING ? 1 : state == AlienState.WAITING || state == AlienState.ATTACKING ? 2 : 1;
    }

    private void initAttackingState() {
	ArrayList<DynamicDisplay> list = new ArrayList<DynamicDisplay>();
	list.add(new DynamicAnimation(AliensArt.tortoiseAttack));
	attackingState = new DynamicDisplayGroup(list);
	attackingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initHidingState() {
	ArrayList<DynamicDisplay> list = new ArrayList<DynamicDisplay>();
	list.add(new DynamicAnimation(AliensArt.tortoiseHiding));
	hidingState = new DynamicDisplayGroup(list);
	hidingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initRisingState() {
	ArrayList<DynamicDisplay> list = new ArrayList<DynamicDisplay>();
	list.add(new DynamicAnimation(AliensArt.tortoiseRising));
	risingState = new DynamicDisplayGroup(list);
	risingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initSmashedState() {
	ArrayList<DynamicDisplay> list = new ArrayList<DynamicDisplay>();
	list.add(new DynamicAnimation(AliensArt.tortoiseSmashed));
	smashedState = new DynamicDisplayGroup(list);
	smashedState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initStunnedState() {
	ArrayList<DynamicDisplay> list = new ArrayList<DynamicDisplay>();
	list.add(new DynamicAnimation(AliensArt.tortoiseStunned));
	stunnedState = new DynamicDisplayGroup(list);
	stunnedState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initWaitingState() {
	ArrayList<DynamicDisplay> list = new ArrayList<DynamicDisplay>();
	list.add(new DynamicAnimation(AliensArt.tortoiseWaiting));
	waitingState = new DynamicDisplayGroup(list);
	waitingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }
}