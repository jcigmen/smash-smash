package com.noobs2d.smashsmash.alien;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Bounce;

import com.noobs2d.smashsmash.screen.AlienEventListener;
import com.noobs2d.tweenengine.utils.DynamicAnimation;
import com.noobs2d.tweenengine.utils.DynamicDisplay.DynamicRegistration;
import com.noobs2d.tweenengine.utils.DynamicSprite;

/**
 * Typical 1-hit alien.
 * 
 * @author Julious Cious Igmen <jcigmen@gmail.com>
 */
public class Jelly extends Alien {

    public static final String RESOURCE = "data/gfx/ALIENS.pack";
    public static final String SHAPE = "JELLY-SHAPE";
    public static final String ATTACK_EYES = "JELLY-ATTACK-EYES";
    public static final String ATTACK_MOUTH = "JELLY-ATTACK-MOUTH";
    public static final String IDLE_EYES = "JELLY-IDLE-EYES";
    public static final String IDLE_MOUTH = "JELLY-IDLE-MOUTH";
    public static final String BLINK_EYES = "JELLY-BLINK-EYES";
    public static final String SMASHED_MOUTH = "JELLY-SMASHED-MOUTH";
    public static final String SMASHED_SHAPE = "JELLY-SMASHED-SHAPE";
    public static final String STUNNED_LEFT_EYE = "JELLY-STUNNED-LEFTEYE";
    public static final String STUNNED_RIGHT_EYE = "JELLY-STUNNED-RIGHTEYE";
    public static final String STUNNED_SHAPE = "JELLY-STUNNED-SHAPE";
    public static final String STUNNED_MOUTH = "JELLY-STUNNED-MOUTH";
    public static final String EXPLODE = "JELLY-EXPLODE";

    public Jelly(AlienEventListener stage) {
	super.callback = stage;
	initRisingState();
	initAttackingState();
	initWaitingState();
	initStunnedState();
	initExplodeState();
	initSmashedState();
	initHidingState();
    }

    @Override
    public int getScore() {
	return state == AlienState.RISING ? 1 : state == AlienState.WAITING || state == AlienState.ATTACKING ? 2 : 1;
    }

    @Override
    protected void initAttackingState() {
	DynamicSprite shape, eyes, mouth;
	shape = new DynamicSprite(AliensArt.jellyShape, 0, 0, DynamicRegistration.BOTTOM_CENTER);
	shape.setName(SHAPE);
	eyes = new DynamicSprite(AliensArt.jellyAttackEyes, 0, 161);
	eyes.setName(ATTACK_EYES);
	mouth = new DynamicSprite(AliensArt.jellyAttackMouth, 0, 156);
	mouth.setName(ATTACK_MOUTH);

	attackingState.add(shape);
	attackingState.add(eyes);
	attackingState.add(mouth);
	attackingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    @Override
    protected void initExplodeState() {
	DynamicAnimation explode = new DynamicAnimation(0.04f, AliensArt.jellyExplode);
	explode.setRegistration(DynamicRegistration.BOTTOM_CENTER);
	explode.setName(EXPLODE);
	explodeState.add(explode);
    }

    @Override
    protected void initHidingState() {
	DynamicSprite shape, eyes, mouth;
	shape = new DynamicSprite(AliensArt.jellyShape, 0, 0, DynamicRegistration.BOTTOM_CENTER);
	shape.setName(SHAPE);
	eyes = new DynamicSprite(AliensArt.jellyIdleEyes, 0, 154, DynamicRegistration.BOTTOM_CENTER);
	eyes.setName(IDLE_EYES);
	mouth = new DynamicSprite(AliensArt.jellyIdleMouth, 0, 129, DynamicRegistration.BOTTOM_CENTER);
	mouth.setName(IDLE_MOUTH);
	hidingState.add(shape);
	hidingState.add(eyes);
	hidingState.add(mouth);
	hidingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    @Override
    protected void initRisingState() {
	DynamicSprite shape, eyes, mouth;
	shape = new DynamicSprite(AliensArt.jellyShape, 0, 0, DynamicRegistration.BOTTOM_CENTER);
	shape.setName(SHAPE);
	eyes = new DynamicSprite(AliensArt.jellyIdleEyes, 0, 154, DynamicRegistration.BOTTOM_CENTER);
	eyes.setName(IDLE_EYES);
	mouth = new DynamicSprite(AliensArt.jellyIdleMouth, 0, 129, DynamicRegistration.BOTTOM_CENTER);
	mouth.setName(IDLE_MOUTH);
	risingState.add(shape);
	risingState.add(eyes);
	risingState.add(mouth);
	risingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    @Override
    protected void initSmashedState() {
	DynamicSprite shape, eyes, mouth;
	shape = new DynamicSprite(AliensArt.jellySmashedShape, 0, 0, DynamicRegistration.BOTTOM_CENTER);
	shape.setName(SHAPE);
	eyes = new DynamicSprite(AliensArt.jellyIdleEyes, 0, 153);
	eyes.setName(IDLE_EYES);
	mouth = new DynamicSprite(AliensArt.jellySmashedMouth, 0, 155);
	mouth.setName(SMASHED_MOUTH);
	smashedState.add(shape);
	smashedState.add(eyes);
	smashedState.add(mouth);
	smashedState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    @Override
    protected void initStunnedState() {
	DynamicSprite shape, leftEye, rightEye, mouth;
	shape = new DynamicSprite(AliensArt.jellyStunnedShape, 0, 0, DynamicRegistration.BOTTOM_CENTER);
	shape.setName(STUNNED_SHAPE);
	leftEye = new DynamicSprite(AliensArt.jellyStunnedLeftEye, -60, 187);
	leftEye.setName(STUNNED_LEFT_EYE);
	rightEye = new DynamicSprite(AliensArt.jellyStunnedRightEye, 69, 175);
	rightEye.setName(STUNNED_RIGHT_EYE);
	mouth = new DynamicSprite(AliensArt.jellyStunnedMouth, 0, 127);
	mouth.setName(STUNNED_MOUTH);
	stunnedState.add(shape);
	stunnedState.add(mouth);
	stunnedState.add(leftEye);
	stunnedState.add(rightEye);
	stunnedState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    @Override
    protected void initWaitingState() {
	DynamicSprite shape, mouth;
	shape = new DynamicSprite(AliensArt.jellyShape, 0, 0, DynamicRegistration.BOTTOM_CENTER);
	shape.setName(SHAPE);
	DynamicAnimation eyes = new DynamicAnimation(.35f, AliensArt.jellyIdleEyes, AliensArt.jellyIdleEyes, AliensArt.jellyIdleEyes, AliensArt.jellyBlinkEyes, AliensArt.jellyIdleEyes);
	eyes.setY(154f);
	eyes.setRegistration(DynamicRegistration.BOTTOM_CENTER);
	eyes.setName(IDLE_EYES);
	mouth = new DynamicSprite(AliensArt.jellyIdleMouth, 0, 129, DynamicRegistration.BOTTOM_CENTER);
	mouth.setName(IDLE_MOUTH);
	waitingState.add(shape);
	waitingState.add(eyes);
	waitingState.add(mouth);
	waitingState.setRegistration(DynamicRegistration.BOTTOM_CENTER);
    }

    @Override
    protected void interpolateAttacking() {
	DynamicSprite shape = (DynamicSprite) attackingState.getByName(SHAPE);
	shape.endTween();
	shape.setScaleY(waitingState.getByName(SHAPE).getScaleY());
	shape.interpolateScaleY(.90f, 750, false).repeatYoyo(10, 0).start(shape.getTweenManager());
	DynamicSprite eyes = (DynamicSprite) attackingState.getByName(ATTACK_EYES);
	eyes.endTween();
	eyes.setPosition(0f, 161f);
	eyes.setScale(.8f);
	eyes.interpolateScaleXY(1.2f, 1.2f, Bounce.OUT, 500, false).repeatYoyo(1, 0).start(eyes.getTweenManager());
	eyes.interpolateXY(eyes.getX(), eyes.getY() - 5, 150, false).repeatYoyo(Tween.INFINITY, 0).start(eyes.getTweenManager());
	DynamicSprite mouth = (DynamicSprite) attackingState.getByName(ATTACK_MOUTH);
	mouth.endTween();
	mouth.setScale(.6f);
	mouth.interpolateScaleXY(1.5f, 1.5f, Bounce.OUT, 500, false).repeatYoyo(1, 0).start(mouth.getTweenManager());
    }

    @Override
    protected void interpolateExplode() {
	((DynamicAnimation) explodeState.getByName(EXPLODE)).reset();
    }

    @Override
    protected void interpolateHiding() {
	DynamicSprite shape = (DynamicSprite) hidingState.getByName(SHAPE);
	shape.endTween();
	shape.setScaleY(waitingState.getByName(SHAPE).getScaleY());
	shape.interpolateScaleY(0f, (int) (1000 * getHidingStateTime()), true);
	DynamicSprite eyes = (DynamicSprite) hidingState.getByName(IDLE_EYES);
	eyes.endTween();
	eyes.setY(waitingState.getByName(IDLE_EYES).getY());
	eyes.setScaleY(1f);
	eyes.interpolateY(0, (int) (1000 * getHidingStateTime()), true);
	eyes.interpolateScaleY(0f, (int) (1000 * getHidingStateTime()), true);
	DynamicSprite mouth = (DynamicSprite) hidingState.getByName(IDLE_MOUTH);
	mouth.endTween();
	mouth.setY(waitingState.getByName(IDLE_MOUTH).getY());
	mouth.setScaleY(1f);
	mouth.interpolateY(0, (int) (1000 * getHidingStateTime()), true);
	mouth.interpolateScaleY(0f, (int) (1000 * getHidingStateTime()), true);
    }

    @Override
    protected void interpolateRising(float delay) {
	DynamicSprite shape = (DynamicSprite) risingState.getByName(SHAPE);
	shape.interpolateScaleY(1f, (int) (1000 * getRisingStateTime()), false).delay(delay);
	shape.setScaleY(0f);
	shape.startTweenWithManager();
	DynamicSprite eyes = (DynamicSprite) risingState.getByName(IDLE_EYES);
	eyes.interpolateY(eyes.getY(), (int) (1000 * getRisingStateTime()), false).delay(delay);
	eyes.startTweenWithManager();
	eyes.interpolateScaleY(1f, (int) (1000 * getRisingStateTime()), false).delay(delay);
	eyes.setY(0f);
	eyes.setScaleY(0f);
	eyes.startTweenWithManager();
	DynamicSprite mouth = (DynamicSprite) risingState.getByName(IDLE_MOUTH);
	mouth.interpolateY(mouth.getY(), (int) (1000 * getRisingStateTime()), false).delay(delay);
	mouth.startTweenWithManager();
	mouth.interpolateScaleY(1f, (int) (1000 * getRisingStateTime()), false).delay(delay);
	mouth.setY(0f);
	mouth.setScaleY(0f);
	mouth.startTweenWithManager();
    }

    @Override
    protected void interpolateSmashed(boolean dead) {
	DynamicSprite shape, eyes, mouth;
	shape = (DynamicSprite) smashedState.getByName(SHAPE);
	shape.endTween();
	shape.setScaleY(waitingState.getByName(SHAPE).getScaleY());
	shape.interpolateScaleY(.8f, 150, true);
	eyes = (DynamicSprite) smashedState.getByName(IDLE_EYES);
	eyes.endTween();
	eyes.setY(153f);
	eyes.setScaleY(1f);
	eyes.interpolateY(eyes.getY() + 50f, 150, false).repeatYoyo(1, 0).start(eyes.getTweenManager());
	mouth = (DynamicSprite) smashedState.getByName(SMASHED_MOUTH);
	mouth.endTween();
	mouth.setY(155f);
	mouth.setScaleY(1f);

	if (dead) {
	    // hide tween
	    shape.interpolateScaleY(0f, 150, true).delay(150);
	    eyes.interpolateScaleY(0f, 150, true).delay(150);
	    eyes.interpolateY(0f, 150, true).delay(150);
	    mouth.interpolateScaleY(0f, 150, true).delay(150);
	    mouth.interpolateY(0f, 150, true).delay(150);
	}
    }

    @Override
    protected void interpolateStunned() {
	DynamicSprite shape, leftEye, rightEye, mouth;
	shape = (DynamicSprite) stunnedState.getByName(STUNNED_SHAPE);
	shape.endTween();
	shape.setScaleY(waitingState.getByName(SHAPE).getScaleY());
	shape.interpolateScaleY(.85f, Bounce.OUT, 350, true);
	leftEye = (DynamicSprite) stunnedState.getByName(STUNNED_LEFT_EYE);
	leftEye.endTween();
	leftEye.setY(187);
	leftEye.interpolateY(leftEye.getY() * .85f, Bounce.OUT, 350, true);
	leftEye.setRotation(0);
	leftEye.setY(leftEye.getY() * waitingState.getByName(SHAPE).getScaleY());
	rightEye = (DynamicSprite) stunnedState.getByName(STUNNED_RIGHT_EYE);
	rightEye.endTween();
	rightEye.setY(175);
	rightEye.interpolateY(rightEye.getY() * .85f, Bounce.OUT, 350, true);
	rightEye.setRotation(0);
	rightEye.setY(rightEye.getY() * waitingState.getByName(SHAPE).getScaleY());
	mouth = (DynamicSprite) stunnedState.getByName(STUNNED_MOUTH);
	mouth.endTween();
	mouth.setY(127);
	mouth.interpolateY(mouth.getY() * .85f, Bounce.OUT, 350, true);
	mouth.setY(mouth.getY() * waitingState.getByName(SHAPE).getScaleY());
    }

    @Override
    protected void interpolateWaiting() {
	DynamicSprite shape = (DynamicSprite) waitingState.getByName(SHAPE);
	shape.killTween();
	shape.setScaleY(1f);
	shape.interpolateScaleY(.90f, 750, false);
	shape.getTween().repeatYoyo(10, 0);
	shape.startTweenWithManager();
	DynamicAnimation eyes = (DynamicAnimation) waitingState.getByName(IDLE_EYES);
	eyes.killTween();
	eyes.setY(154f);
	eyes.interpolateY(134f, 750, false).repeatYoyo(10, 0).start(eyes.getTweenManager());
	DynamicSprite mouth = (DynamicSprite) waitingState.getByName(IDLE_MOUTH);
	mouth.killTween();
	mouth.setY(129f);
	mouth.interpolateY(109f, 750, false).repeatYoyo(10, 0).start(mouth.getTweenManager());
    }

}
