[参考文档](http://blog.csdn.net/guolin_blog/article/details/43536355)
##帧动画

####一：什么是帧动画?
       逐帧动画通过连续播放图片来模拟动画的效果

主要实现为一下代码:
注意:AnimationDrawable对象在获取的时候,更具你图片的设置获取的，
1. 如果设置的是src属性,就要ivAnimation.getBackground()来获得
2.  如果设置的是background属性,就要 ivAnimation.getBackground()来获得

        AnimationDrawable animationDrawable = (AnimationDrawable) ivAnimation.getBackground();
        //        animationDrawable.start();//开始
        // animationDrawable.setOneShot(false);是否循环播放
        // animationDrawable.stop();停止播放
        // animationDrawable.isRunning();//是否播放
        // animationDrawable.getNumberOfFrames();//播放帧
        // animationDrawable.getFrame(index); 返回制定索引的 Drawable对象
        // animationDrawable.getDuration(i);停留的时间

##补间动画
####一:什么是补间动画?
        所谓补间动画，是指通过指定View的初末状态和变化时间、方式，对View的内容完成一系列的图形变换来实现动画效果。主要包括四种效果：Alpha、Scale、Translate和Rotate。
        补间动画仅仅是可视属性在显示层面的动画，属性的实质并未改动。
###注意: 补间动画还有一个致命的缺陷，就是它只是改变了View的显示效果而已，而不会真正去改变View的属性
目前Android应用框架支持的补间动画效果有以下5种。
>AlphaAnimation：透明度（alpha）渐变效果，对应<alpha/>标签。
TranslateAnimation：位移渐变，需要指定移动点的开始和结束坐标，对应<translate/>标签。
ScaleAnimation：缩放渐变，可以指定缩放的参考点，对应<scale/>标签。
RotateAnimation：旋转渐变，可以指定旋转的参考点，对应<rotate/>标签。
AnimationSet：组合渐变，支持组合多种渐变效果，对应<set/>标签。

补间动画的效果同样可以使用XML语言来定义，这些动画模板文件通常会被放在Android项目的res/anim/目录下。



        // 透明动画
    public void alphaImpl(View view) {

        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.alpha_demo);
        view.startAnimation(animation);
    }

    // 旋转动画
    public void rotateImpl(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.rotate_demo);
        view.startAnimation(animation);
    }

    // 缩放动画
    public void scaleImpl(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.scale_demo);
        view.startAnimation(animation);
    }

    // 移动效果
    public void translateImpl(View view) {
        // XML文件
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.translate_demo);

        animation.setRepeatCount(Animation.INFINITE);//循环显示
        view.startAnimation(animation);

        /*
         * 第一种 imageView.setAnimation(animation); animation.start();
         */
        // 第二种

        // Java代码
        /*
         * TranslateAnimation translateAnimation = new TranslateAnimation(0,
         * 200, 0, 0); translateAnimation.setDuration(2000);
         * imageView.startAnimation(translateAnimation);
         */
    }

    // 综合实现set_demo.xml中的动画
    public void setAll(View view) {
        Animation animation = AnimationUtils.loadAnimation(this,
                R.anim.set_demo);
        view.startAnimation(animation);
    }



###alpha_demo.xml
    <alpha xmlns:android="http://schemas.android.com/apk/res/android"  
    android:interpolator="@android:anim/accelerate_decelerate_interpolator"  
    android:fromAlpha="1.0"  
    android:toAlpha="0.1"  
    android:duration="2000"/>  
         <!--   
         fromAlpha :起始透明度  
         toAlpha:结束透明度  
         1.0表示完全不透明  
         0.0表示完全透明  
          -->  



###rotate_demo.xml

    <rotate xmlns:android="http://schemas.android.com/apk/res/android"  
    android:interpolator="@android:anim/accelerate_decelerate_interpolator"  
    android:fromDegrees="0"  
    android:toDegrees="360"  
    android:duration="1000"  
    android:repeatCount="1"  
    android:repeatMode="reverse"/>  
    <!--   
    fromDegrees:表示旋转的起始角度  
    toDegrees:表示旋转的结束角度  
    repeatCount:旋转的次数  默认值是0 代表旋转1次  如果值是repeatCount=4 旋转5次，值为-1或者infinite时，表示补间动画永不停止  
    repeatMode 设置重复的模式。默认是restart。当repeatCount的值大于0或者为infinite时才有效。  
    repeatCount=-1 或者infinite 循环了  
    还可以设成reverse，表示偶数次显示动画时会做与动画文件定义的方向相反的方向动行。  
     -->  

###scale_demo.xml
    <scale xmlns:android="http://schemas.android.com/apk/res/android"  
    android:interpolator="@android:anim/accelerate_interpolator"  
    android:fromXScale="0.2"  
    android:toXScale="1.5"  
    android:fromYScale="0.2"  
    android:toYScale="1.5"  
    android:pivotX="50%"  
    android:pivotY="50%"  
    android:duration="2000"/>  
  
    <!--   
    fromXScale:表示沿着x轴缩放的起始比例  
    toXScale:表示沿着x轴缩放的结束比例  
  
    fromYScale:表示沿着y轴缩放的起始比例  
    toYScale:表示沿着y轴缩放的结束比例  
  
    图片中心点：  
      android:pivotX="50%"   
      android:pivotY="50%"  
  
     -->  

###translate_demo.xml
    <translate xmlns:android="http://schemas.android.com/apk/res/android"  
    android:interpolator="@android:anim/accelerate_decelerate_interpolator"  
    android:fromXDelta="0"  
    android:toXDelta="320"  
    android:fromYDelta="0"  
    android:toYDelta="0"  
    android:duration="2000"/>   
      
    <!--   
      android:interpolator 动画的渲染器  
      1、accelerate_interpolator(动画加速器) 使动画在开始的时候 最慢,然后逐渐加速  
      2、decelerate_interpolator(动画减速器)使动画在开始的时候 最快,然后逐渐减速  
      3、accelerate_decelerate_interpolator（动画加速减速器）  
           中间位置分层:  使动画在开始的时候 最慢,然后逐渐加速           
          使动画在开始的时候 最快,然后逐渐减速  结束的位置最慢  
     fromXDelta  动画起始位置的横坐标  
     toXDelta    动画起结束位置的横坐标  
     fromYDelta  动画起始位置的纵坐标  
     toYDelta   动画结束位置的纵坐标  
     duration 动画的持续时间  
     -->  



##属性动画
####一:什么是属性动画?
        属性动画和补间动画类似，不过是真的属性在变动，包括可视属性和其他属性。一般情况下推荐使用最新的属性动画。
不熟悉舒心动画的可以先去了解一下 [**Android属性动画完全解析(上)，初识属性动画的基本用法**](http://blog.csdn.net/guolin_blog/article/details/43536355) 。
####属性动画的实现机制是通过对目标对象进行赋值并修改其属性来实现的

##ValueAnimator

>ValueAnimator是整个属性动画机制当中最核心的一个类，前面我们已经提到了，属性动画的运行机制是通过不断地对值进行操作来实现的，而初始值和结束值之间的动画过渡就是由ValueAnimator这个类来负责计算的。它的内部使用一种时间循环的机制来计算值与值之间的动画过渡，我们只需要将初始值和结束值提供给ValueAnimator，并且告诉它动画所需运行的时长，那么ValueAnimator就会自动帮我们完成从初始值平滑地过渡到结束值这样的效果。除此之外，ValueAnimator还负责管理动画的播放次数、播放模式、以及对动画设置监听器等，确实是一个非常重要的类。

例子:
我们先从最简单的功能看起吧，比如说想要将一个值从0平滑过渡到1，时长300毫秒，就可以这样写：

    ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);  
    anim.setDuration(300);  
    anim.start(); 

怎么样？很简单吧，调用ValueAnimator的ofFloat()方法就可以构建出一个ValueAnimator的实例，ofFloat()方法当中允许传入多个float类型的参数，这里传入0和1就表示将值从0平滑过渡到1，然后调用ValueAnimator的setDuration()方法来设置动画运行的时长，最后调用start()方法启动动画。
用法就是这么简单，现在如果你运行一下上面的代码，动画就会执行了。可是这只是一个将值从0过渡到1的动画，又看不到任何界面效果，我们怎样才能知道这个动画是不是已经真正运行了呢？这就需要借助监听器来实现了，如下所示：

    ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);  
    anim.setDuration(300);  
    anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {  
         @Override  
        public void onAnimationUpdate(ValueAnimator animation) {  
            float currentValue = (float) animation.getAnimatedValue();  
            Log.e("ShuXinActivity===","value==="+value);
        }  
    });  
    anim.start();  


可以看到，这里我们通过addUpdateListener()方法来添加一个动画的监听器，在动画执行的过程中会不断地进行回调，我们只需要在回调方法当中将当前的值取出并打印出来，就可以知道动画有没有真正运行了。运行上述代码，控制台打印如下所示：

![测试结果.png](http://upload-images.jianshu.io/upload_images/1387450-3748030b5acfac68.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

ValueAnimator帮助我们完成的。另外ofFloat()方法当中是可以传入任意多个参数的，因此我们还可以构建出更加复杂的动画逻辑，比如说将一个值在5秒内从0过渡到5，再过渡到3，再过渡到10，就可以这样写：

    ValueAnimator anim = ValueAnimator.ofFloat(0f, 5f, 3f, 10f);  
    anim.setDuration(5000);  
    anim.start(); 

当然也许你并不需要小数位数的动画过渡，可能你只是希望将一个整数值从0平滑地过渡到100，那么也很简单，只需要调用ValueAnimator的ofInt()方法就可以了，如下所示：

    ValueAnimator anim = ValueAnimator.ofInt(0, 100); 


ValueAnimator当中最常用的应该就是ofFloat()和ofInt()这两个方法了，另外还有一个ofObject()方法




##ObjectAnimator

相比于ValueAnimator，ObjectAnimator可能才是我们最常接触到的类，因为ValueAnimator只不过是对值进行了一个平滑的动画过渡，但我们实际使用到这种功能的场景好像并不多。而ObjectAnimator则就不同了，它是可以直接对任意对象的任意属性进行动画操作的，比如说View的alpha属性。

不过虽说ObjectAnimator会更加常用一些，但是它其实是继承自ValueAnimator的，底层的动画实现机制也是基于ValueAnimator来完成的，因此ValueAnimator仍然是整个属性动画当中最核心的一个类。那么既然是继承关系，说明ValueAnimator中可以使用的方法在ObjectAnimator中也是可以正常使用的，它们的用法也非常类似，这里如果我们想要将一个TextView在5秒中内从常规变换成全透明，再从全透明变换成常规，就可以这样写：


    ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);  
    animator.setDuration(5000);  
    animator.start();  


可以看到，我们还是调用了ofFloat()方法来去创建一个ObjectAnimator的实例，只不过ofFloat()方法当中接收的参数有点变化了。这里第一个参数要求传入一个object对象，我们想要对哪个对象进行动画操作就传入什么，这里我传入了一个textview。第二个参数是想要对该对象的哪个属性进行动画操作，由于我们想要改变TextView的不透明度，因此这里传入"alpha"。后面的参数就是不固定长度了，想要完成什么样的动画就传入什么值，这里传入的值就表示将TextView从常规变换成全透明，再从全透明变换成常规。之后调用setDuration()方法来设置动画的时长，然后调用start()方法启动动画


![运行结果](http://upload-images.jianshu.io/upload_images/1387450-e76345026311c4ee?imageMogr2/auto-orient/strip)


学会了这一个用法之后，其它的用法我们就可以举一反三了，那比如说我们想要将TextView进行一次360度的旋转，就可以这样写：

    ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);  
    animator.setDuration(5000);  
    animator.start(); 

运行结果如下
![测试结果](http://upload-images.jianshu.io/upload_images/1387450-594321ff5774f6c2?imageMogr2/auto-orient/strip)



那么如果想要将TextView先向左移出屏幕，然后再移动回来，就可以这样写：

    float curTranslationX = textview.getTranslationX();  
    ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "translationX", curTranslationX, -500f, curTranslationX);  
    animator.setDuration(5000);  
    animator.start(); 

这里我们先是调用了TextView的getTranslationX()方法来获取到当前TextView的translationX的位置，然后ofFloat()方法的第二个参数传入"translationX"，紧接着后面三个参数用于告诉系统TextView应该怎么移动，现在运行一下代码，效果如下图所示：

![测试结果](http://upload-images.jianshu.io/upload_images/1387450-00ef42a803a75d26?imageMogr2/auto-orient/strip)

然后我们还可以TextView进行缩放操作，比如说将TextView在垂直方向上放大3倍再还原，就可以这样写：

    ObjectAnimator animator = ObjectAnimator.ofFloat(textview, "scaleY", 1f, 3f, 1f);  
    animator.setDuration(5000);  
    animator.start(); 

这里将ofFloat()方法的第二个参数改成了"scaleY"，表示在垂直方向上进行缩放，现在重新运行一下程序，效果如下图所示：

![测试结果](http://upload-images.jianshu.io/upload_images/1387450-972c776696cb4eeb?imageMogr2/auto-orient/strip)

到目前为止，ObjectAnimator的用法还算是相当简单吧，但是我相信肯定会有不少朋友现在心里都有同样一个疑问，就是ofFloat()方法的第二个参数到底可以传哪些值呢？目前我们使用过了alpha、rotation、translationX和scaleY这几个值，分别可以完成淡入淡出、旋转、水平移动、垂直缩放这几种动画，那么还有哪些值是可以使用的呢？其实这个问题的答案非常玄乎，就是我们可以传入任意的值到ofFloat()方法的第二个参数当中。任意的值？相信这很出乎大家的意料吧，但事实就是如此。因为ObjectAnimator在设计的时候就没有针对于View来进行设计，而是针对于任意对象的，它所负责的工作就是不断地向某个对象中的某个属性进行赋值，然后对象根据属性值的改变再来决定如何展现出来。
那么比如说我们调用下面这样一段代码：

    ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f);  

其实这段代码的意思就是ObjectAnimator会帮我们不断地改变textview对象中alpha属性的值，从1f变化到0f。然后textview对象需要根据alpha属性值的改变来不断刷新界面的显示，从而让用户可以看出淡入淡出的动画效果。
那么textview对象中是不是有alpha属性这个值呢？没有，不仅textview没有这个属性，连它所有的父类也是没有这个属性的！这就奇怪了，textview当中并没有alpha这个属性，ObjectAnimator是如何进行操作的呢？其实ObjectAnimator内部的工作机制并不是直接对我们传入的属性名进行操作的，而是会去寻找这个属性名对应的get和set方法，因此alpha属性所对应的get和set方法应该就是：

    public void setAlpha(float value);  
    public float getAlpha(); 

那么textview对象中是否有这两个方法呢？确实有，并且这两个方法是由View对象提供的，也就是说不仅TextView可以使用这个属性来进行淡入淡出动画操作，任何继承自View的对象都可以的。
既然alpha是这个样子，相信大家一定已经明白了，前面我们所用的所有属性都是这个工作原理，那么View当中一定也存在着setRotation()、getRotation()、setTranslationX()、getTranslationX()、setScaleY()、getScaleY()这些方法，不信的话你可以到View当中去找一下。



##组合动画


独立的动画能够实现的视觉效果毕竟是相当有限的，因此将多个动画组合到一起播放就显得尤为重要。幸运的是，Android团队在设计属性动画的时候也充分考虑到了组合动画的功能，因此提供了一套非常丰富的API来让我们将多个动画组合到一起。
实现组合动画功能主要需要借助AnimatorSet这个类，这个类提供了一个play()方法，如果我们向这个方法中传入一个Animator对象(ValueAnimator或ObjectAnimator)将会返回一个AnimatorSet.Builder的实例，AnimatorSet.Builder中包括以下四个方法：

>1. after(Animator anim)   将现有动画插入到传入的动画之后执行
2. after(long delay)   将现有动画延迟指定毫秒后执行
3. before(Animator anim)   将现有动画插入到传入的动画之前执行
4. with(Animator anim)   将现有动画和传入的动画同时执行

好的，有了这四个方法，我们就可以完成组合动画的逻辑了，那么比如说我们想要让TextView先从屏幕外移动进屏幕，然后开始旋转360度，旋转的同时进行淡入淡出操作，就可以这样写：

    ObjectAnimator moveIn = ObjectAnimator.ofFloat(textview, "translationX", -500f, 0f);  
    ObjectAnimator rotate = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);  
    ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);  
    AnimatorSet animSet = new AnimatorSet();  
    animSet.play(rotate).with(fadeInOut).after(moveIn);  
    animSet.setDuration(5000);  
    animSet.start();



可以看到，这里我们先是把三个动画的对象全部创建出来，然后new出一个AnimatorSet对象之后将这三个动画对象进行播放排序，让旋转和淡入淡出动画同时进行，并把它们插入到了平移动画的后面，最后是设置动画时长以及启动动画。运行一下上述代码，效果如下图所示：

![测试结果](http://upload-images.jianshu.io/upload_images/1387450-9cbeca5cd5f61222?imageMogr2/auto-orient/strip)


##Animator监听器
在很多时候，我们希望可以监听到动画的各种事件，比如动画何时开始，何时结束，然后在开始或者结束的时候去执行一些逻辑处理。这个功能是完全可以实现的，Animator类当中提供了一个addListener()方法，这个方法接收一个AnimatorListener，我们只需要去实现这个AnimatorListener就可以监听动画的各种事件了。

大家已经知道，ObjectAnimator是继承自ValueAnimator的，而ValueAnimator又是继承自Animator的，因此不管是ValueAnimator还是ObjectAnimator都是可以使用addListener()这个方法的。另外AnimatorSet也是继承自Animator的，因此addListener()这个方法算是个通用的方法。
添加一个监听器的代码如下所示：

    anim.addListener(new AnimatorListener() {  

    @Override  
    public void onAnimationStart(Animator animation) {  
    }  
  
    @Override  
    public void onAnimationRepeat(Animator animation) {  
    }  
  
    @Override  
    public void onAnimationEnd(Animator animation) {  
    }  
  
    @Override  
    public void onAnimationCancel(Animator animation) {  
    }  
}); 



##使用XML编写动画

我们可以使用代码来编写所有的动画功能，这也是最常用的一种做法。不过，过去的补间动画除了使用代码编写之外也是可以使用XML编写的，因此属性动画也提供了这一功能，即通过XML来完成和代码一样的属性动画功能。
通过XML来编写动画可能会比通过代码来编写动画要慢一些，但是在重用方面将会变得非常轻松，比如某个将通用的动画编写到XML里面，我们就可以在各个界面当中轻松去重用它。

如果想要使用XML来编写动画，首先要在res目录下面新建一个animator文件夹，所有属性动画的XML文件都应该存放在这个文件夹当中。然后在XML文件中我们一共可以使用如下三种标签：

* <animator>  对应代码中的ValueAnimator
* <objectAnimator>  对应代码中的ObjectAnimator
* <set>  对应代码中的AnimatorSet

那么比如说我们想要实现一个从0到100平滑过渡的动画，在XML当中就可以这样写：

    <animator xmlns:android="http://schemas.android.com/apk/res/android"  
    android:valueFrom="0"  
    android:valueTo="100"  
    android:valueType="intType"/> 


    <objectAnimator xmlns:android="http://schemas.android.com/apk/res/android"  
    android:valueFrom="1"  
    android:valueTo="0"  
    android:valueType="floatType"  
    android:propertyName="alpha"/> 


另外，我们也可以使用XML来完成复杂的组合动画操作，比如将一个视图先从屏幕外移动进屏幕，然后开始旋转360度，旋转的同时进行淡入淡出操作，就可以这样写：

    <set xmlns:android="http://schemas.android.com/apk/res/android"  
    android:ordering="sequentially" >  
  
    <objectAnimator  
        android:duration="2000"  
        android:propertyName="translationX"  
        android:valueFrom="-500"  
        android:valueTo="0"  
        android:valueType="floatType" >  
    </objectAnimator>  
  
    <set android:ordering="together" >  
        <objectAnimator  
            android:duration="3000"  
            android:propertyName="rotation"  
            android:valueFrom="0"  
            android:valueTo="360"  
            android:valueType="floatType" >  
        </objectAnimator>  
  
        <set android:ordering="sequentially" >  
            <objectAnimator  
                android:duration="1500"  
                android:propertyName="alpha"  
                android:valueFrom="1"  
                android:valueTo="0"  
                android:valueType="floatType" >  
            </objectAnimator>  
            <objectAnimator  
                android:duration="1500"  
                android:propertyName="alpha"  
                android:valueFrom="0"  
                android:valueTo="1"  
                android:valueType="floatType" >  
            </objectAnimator>  
        </set>  
    </set>  
  
    </set> 

这段XML实现的效果和我们刚才通过代码来实现的组合动画的效果是一模一样的，每个参数的含义都非常清楚，相信大家都是一看就懂，我就不再一一解释了。
最后XML文件是编写好了，那么我们如何在代码中把文件加载进来并将动画启动呢？只需调用如下代码即可：

    Animator animator = AnimatorInflater.loadAnimator(context, R.animator.anim_file);  
    animator.setTarget(view);  
    animator.start();

调用AnimatorInflater的loadAnimator来将XML动画文件加载进来，然后再调用setTarget()方法将这个动画设置到某一个对象上面，最后再调用start()方法启动动画就可以了，就是这么简单。

最后分享[github项目]()
