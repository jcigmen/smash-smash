package com.nullsys.smashsmash.alien;

import java.util.ArrayList;

import com.noobs2d.tweenengine.utils.DynamicAnimation;
import com.noobs2d.tweenengine.utils.DynamicAnimationGroup;
import com.noobs2d.tweenengine.utils.DynamicDisplay.DynamicRegistration;
import com.nullsys.smashsmash.Sounds;
import com.nullsys.smashsmash.screen.SmashSmashStageCallback;

public class Fluff extends Alien {

    public Fluff(SmashSmashStageCallback stage) {
	super.stage = stage;
	SFXspawn = Sounds.jellySpawn;
	SFXsmash = Sounds.jellySmash;
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
	ArrayList<DynamicAnimation> list = new ArrayList<DynamicAnimation>();
	list.add(new DynamicAnimation(AliensArt.fluffAttack));
	attackingState = new DynamicAnimationGroup(list);
	attackingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initHidingState() {
	ArrayList<DynamicAnimation> list = new ArrayList<DynamicAnimation>();
	list.add(new DynamicAnimation(AliensArt.fluffHiding));
	hidingState = new DynamicAnimationGroup(list);
	hidingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initRisingState() {
	ArrayList<DynamicAnimation> list = new ArrayList<DynamicAnimation>();
	list.add(new DynamicAnimation(AliensArt.fluffRising));
	risingState = new DynamicAnimationGroup(list);
	risingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initSmashedState() {
	ArrayList<DynamicAnimation> list = new ArrayList<DynamicAnimation>();
	list.add(new DynamicAnimation(AliensArt.fluffSmashed));
	smashedState = new DynamicAnimationGroup(list);
	smashedState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initStunnedState() {
	ArrayList<DynamicAnimation> list = new ArrayList<DynamicAnimation>();
	list.add(new DynamicAnimation(AliensArt.fluffStunned));
	stunnedState = new DynamicAnimationGroup(list);
	stunnedState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    private void initWaitingState() {
	ArrayList<DynamicAnimation> list = new ArrayList<DynamicAnimation>();
	list.add(new DynamicAnimation(AliensArt.fluffWaiting));
	waitingState = new DynamicAnimationGroup(list);
	waitingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }
}
