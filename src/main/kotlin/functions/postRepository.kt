package functions

import data.Post

fun getPostList(): List<Post> {
    return listOf(
            Post(title = "Programming in your head",
                    preview = "<p>Programming started out as just a job for me. I started enjoying it with time and still do. When I started out, I was like most programmers; Start hacking code and try to make it work. I copied pasted code from other files, Stack-overflow and the rest of the internet. I did not understand the programming language, the frameworks or the domain much. The focus was on ‘getting something to work’. Naturally, I was not a productive developer.</p>",
                    content = "<h3 name=\"c98d\" id=\"c98d\" class=\"graf graf--h3 graf--leading graf--title\">Programming in your&nbsp;head</h3><p name=\"f33b\" id=\"f33b\" class=\"graf graf--p graf-after--h3\">Programming started out as just a job for me. I started enjoying it with time and still do. When I started out, I was like most programmers; Start hacking code and try to make it work. I copied pasted code from other files, Stack-overflow and the rest of the internet. I did not understand the programming language, the frameworks or the domain much. The focus was on ‘getting something to work’. Naturally, I was not a productive developer. It has been eleven years since I started programming professionally and I am a much better programmer today. I have to thank the developers whom I worked with and the businesses who employed me. I think a huge part of being a good software developer means having skills that have nothing to do with typing on the keyboard.</p><h4 name=\"caab\" id=\"caab\" class=\"graf graf--h4 graf-after--p\">Happy stories and sad&nbsp;stories</h4><p name=\"7e9b\" id=\"7e9b\" class=\"graf graf--p graf-after--h4\">I have always felt in the ‘zone’ when developing some stories. It just felt good every single day when I was doing those stories. The software that I delivered was on time, with lesser defects. I can still remember a lot of those stories even after so many years. For some other stories, it felt really hard to get anything going. I somehow muddled through them and they took much longer than I had planned. The quality of software decreased as my frustration levels increased. I felt demotivated every single day I did those stories and I can remember a few of them as well. It felt that like life, work also had happy stories and sad ones.</p><h4 name=\"a020\" id=\"a020\" class=\"graf graf--h4 graf-after--p\">Taking a step&nbsp;back</h4><p name=\"e2ba\" id=\"e2ba\" class=\"graf graf--p graf-after--h4\">I realised that the happy stories were the ones where I knew the end state and the steps to get to the end state in my head even before I started the story. It was just about executing to a script in your head. I could test drive these easily and write higher quality software. The sad stories were always the ones where there were a lot unknowns and I dived into programming right away. I made assumptions and always had surprises and schedule slippages waiting for me.</p><h4 name=\"c6c2\" id=\"c6c2\" class=\"graf graf--h4 graf-after--p\">Programming in your&nbsp;head</h4><p name=\"ef6f\" id=\"ef6f\" class=\"graf graf--p graf-after--h4\">In <a href=\"https://twitter.com/richhickey\" data-href=\"https://twitter.com/richhickey\" class=\"markup--anchor markup--p-anchor\" rel=\"noopener\" target=\"_blank\">Rich Hickey’s</a> classic video called <a href=\"https://www.youtube.com/watch?v=f84n5oFoZBc&amp;feature=youtu.be&amp;t=176\" data-href=\"https://www.youtube.com/watch?v=f84n5oFoZBc&amp;feature=youtu.be&amp;t=176\" class=\"markup--anchor markup--p-anchor\" rel=\"noopener\" target=\"_blank\">hammock driven development</a>, he says that</p><blockquote name=\"ac9c\" id=\"ac9c\" class=\"graf graf--blockquote graf-after--p\">Bugs are the easiest to avoid in design</blockquote><blockquote name=\"123d\" id=\"123d\" class=\"graf graf--blockquote graf-after--blockquote\">The Biggest problems in software are problems of misconception.</blockquote><p name=\"0771\" id=\"0771\" class=\"graf graf--p graf-after--blockquote\">The most important thing for a developer is to resist the temptation of getting down to code as soon as possible. You first have to understand the problem, come to a solution and make sure you de-risk the unknowns before you start implementing the solution. You will have to do things that you may not like; For example, talking to people like product folks, customers and operations or getting feedback on your design from other developers. You may have to do tech spikes to de-risk unknowns before you write production code. You need to make sure that you have a script in your head which you can execute. Sure, there will be unforeseen scenarios that you may not have thought about, but it will be way better than getting to code and going down an expensive rabbit hole.</p><p name=\"8bb4\" id=\"8bb4\" class=\"graf graf--p graf-after--p graf--trailing\">Remember that your job is to solve problems and that happens in your head. Typing code is just a small part of the job.</p>"
            ),
            Post(title = "Scaling Redux part 3: Reducing Boilerplate and other stories",
                    preview = "<p>In Scaling Redux part 1 and 2, I talked about how codebase and state architecture impacts complex applications. This post is about some other common problems that you encounter when your Redux codebase grows. </p>",
                    content = "<h3 name=\"a389\" id=\"a389\" class=\"graf graf--h3 graf--leading graf--title\">Scaling Redux part 3: Reducing Boilerplate and other&nbsp;stories</h3><p name=\"deae\" id=\"deae\" class=\"graf graf--p graf-after--h3\">In Scaling Redux <a href=\"https://medium.com/@uttamkini/scaling-redux-part-1-codebase-organization-80f978cd8a72\" data-href=\"https://medium.com/@uttamkini/scaling-redux-part-1-codebase-organization-80f978cd8a72\" class=\"markup--anchor markup--p-anchor\" target=\"_blank\">part 1</a> <a href=\"https://medium.com/@uttamkini/scaling-redux-part-2-organizing-state-8a1c5e8fffbf\" data-href=\"https://medium.com/@uttamkini/scaling-redux-part-2-organizing-state-8a1c5e8fffbf\" class=\"markup--anchor markup--p-anchor\" target=\"_blank\">and 2</a>, I talked about how codebase and state architecture impacts complex applications. This post is about some other common problems that you encounter when your Redux codebase grows.</p><h4 name=\"ac22\" id=\"ac22\" class=\"graf graf--h4 graf-after--p\">Eliminate Switch Case&nbsp;Fatigue</h4><p name=\"5e67\" id=\"5e67\" class=\"graf graf--p graf-after--h4\">Redux’s benefits of one way data flow, time travelling debugging etc come at a cost of more abstractions (to remember and type). One common example is the oft repeated switch case statements in reducers which look like the following</p><pre name=\"019e\" id=\"019e\" class=\"graf graf--pre graf-after--p\"><strong class=\"markup--strong markup--pre-strong\">const </strong>reducer = <strong class=\"markup--strong markup--pre-strong\">function</strong>(state, action) {<br>    state = state || defaultState;<br>    <strong class=\"markup--strong markup--pre-strong\">switch </strong>(action.<strong class=\"markup--strong markup--pre-strong\">type</strong>) {<br>        <strong class=\"markup--strong markup--pre-strong\">case </strong>ACTION_1:<br>            <strong class=\"markup--strong markup--pre-strong\">return {... state, {\"foo\": \"bar\"}};</strong><br>        <strong class=\"markup--strong markup--pre-strong\">case </strong>ACTION_2:<br>            <strong class=\"markup--strong markup--pre-strong\">return </strong> <strong class=\"markup--strong markup--pre-strong\">return {... state, {\"zoo\": \"zaz\"}}<br>        <br>        ...<br>        ...</strong></pre><pre name=\"356f\" id=\"356f\" class=\"graf graf--pre graf-after--pre\">        <strong class=\"markup--strong markup--pre-strong\">default</strong>:<br>            <strong class=\"markup--strong markup--pre-strong\">return </strong>state;<br>    }</pre><p name=\"6213\" id=\"6213\" class=\"graf graf--p graf-after--pre\">The switch case statement is a hangover of sample code and tutorial apps. Though easy to read at first glance, it is a line too many to type and by extension mistype. Mistypes can create subtle defects that take a long time to debug.</p><p name=\"36af\" id=\"36af\" class=\"graf graf--p graf-after--p\">If we write a wrapper reducer function like</p><pre name=\"1c51\" id=\"1c51\" class=\"graf graf--pre graf-after--p\"><strong class=\"markup--strong markup--pre-strong\">const </strong>declarativeReducer = (defaultState, config) =&gt; {<em class=\"markup--em markup--pre-em\"><br>    </em><strong class=\"markup--strong markup--pre-strong\">return </strong>(state, action) =&gt; {<br>        state = state || defaultState;<br>        action = action || {<strong class=\"markup--strong markup--pre-strong\">type</strong>: <strong class=\"markup--strong markup--pre-strong\">null</strong>};<br><br>        <strong class=\"markup--strong markup--pre-strong\">const </strong>handler = config[action.<strong class=\"markup--strong markup--pre-strong\">type</strong>] || (() =&gt; (state));<br>        <strong class=\"markup--strong markup--pre-strong\">return </strong>handler(state, action.<strong class=\"markup--strong markup--pre-strong\">payload</strong>);<br>    };<br>};</pre><p name=\"4d30\" id=\"4d30\" class=\"graf graf--p graf-after--pre\">then the above reducer becomes,</p><pre name=\"285d\" id=\"285d\" class=\"graf graf--pre graf-after--p\"><strong class=\"markup--strong markup--pre-strong\">const </strong>reducer = declarativeReducer(defaultState, {<br>        [ACTION_1]: (state, payload) =&gt; <strong class=\"markup--strong markup--pre-strong\"> {... state, {\"foo\":\"bar\"}}</strong>,<br>        [ACTION_2]: (state, payload) =&gt;  <strong class=\"markup--strong markup--pre-strong\">{... state, {\"zoo\": \"zaz\"}}</strong><br>      });</pre><p name=\"6e74\" id=\"6e74\" class=\"graf graf--p graf-after--pre\">As you can see the reducer is now declarative and you just have to type in only as much as it is really required to handle the action.</p><h4 name=\"3045\" id=\"3045\" class=\"graf graf--h4 graf-after--p\">Namespace your Action&nbsp;Types</h4><p name=\"1d59\" id=\"1d59\" class=\"graf graf--p graf-after--h4\">As you grow your codebase, you will have a lot of actions and action types. There is a chance that you may have duplicate action names. This can be quite disastrous and can get your app into an inconsistent state if a wrong subtree is updated unintentionally. The solution to this is quite simple though. Namespace your action types with the ‘Ducks’ that they reside in. for example for an action to Fetch orders that lies in <code class=\"markup--code markup--p-code\">data/OrderDuck.js</code>&nbsp;, name it <code class=\"markup--code markup--p-code\">DATA_ORDER_FETCH_ORDER</code>&nbsp;. You can choose your own convention, as long as it is hard to duplicate action types.</p><h4 name=\"75e1\" id=\"75e1\" class=\"graf graf--h4 graf-after--p\">Have a large number of small Reducers/Ducks</h4><p name=\"dcc3\" id=\"dcc3\" class=\"graf graf--p graf-after--h4\">One other anti-pattern that I encountered was the God Reducer/God Duck akin to the <a href=\"https://en.wikipedia.org/wiki/God_object\" data-href=\"https://en.wikipedia.org/wiki/God_object\" class=\"markup--anchor markup--p-anchor\" rel=\"noopener\" target=\"_blank\">God Object</a> pattern. A lot of actions and reducer logic starts going into one file or abstraction. To overcome this, make sure that you keep your Ducks as small as possible. One smell that you haven’t done this enough is when you haven’t used <code class=\"markup--code markup--p-code\">combineReducers</code> a lot in your codebase. If you follow the directory and state structure as described in Scaling Redux <a href=\"https://medium.com/@uttamkini/scaling-redux-part-1-codebase-organization-80f978cd8a72\" data-href=\"https://medium.com/@uttamkini/scaling-redux-part-1-codebase-organization-80f978cd8a72\" class=\"markup--anchor markup--p-anchor\" target=\"_blank\">part 1</a> <a href=\"https://medium.com/@uttamkini/scaling-redux-part-2-organizing-state-8a1c5e8fffbf\" data-href=\"https://medium.com/@uttamkini/scaling-redux-part-2-organizing-state-8a1c5e8fffbf\" class=\"markup--anchor markup--p-anchor\" target=\"_blank\">and 2</a>, then it is quite intuitive to have small reducers composed in hierarchy like the following,</p><pre name=\"9eec\" id=\"9eec\" class=\"graf graf--pre graf-after--p\"><strong class=\"markup--strong markup--pre-strong\">const </strong>appReducer = combineReducers({<br>    <strong class=\"markup--strong markup--pre-strong\">data</strong>: dataReducer,<br>    <strong class=\"markup--strong markup--pre-strong\">ui</strong>: uiReducer<br>});</pre><pre name=\"5b2a\" id=\"5b2a\" class=\"graf graf--pre graf-after--pre\"><strong class=\"markup--strong markup--pre-strong\">const </strong>uiReducer = combineReducers({<br>    <strong class=\"markup--strong markup--pre-strong\">headerReducer</strong>: HeaderReducer,<br>    <strong class=\"markup--strong markup--pre-strong\">bodyReducer:</strong> BodyReducer,<br>    <strong class=\"markup--strong markup--pre-strong\">sideBarReducer:</strong> SideBarReducer<br>});</pre><pre name=\"d1fa\" id=\"d1fa\" class=\"graf graf--pre graf-after--pre\"><strong class=\"markup--strong markup--pre-strong\">const </strong>dataReducer = combineReducers({<br>    <strong class=\"markup--strong markup--pre-strong\">orderDataReducer</strong>: orderDataReducer,<br>    <strong class=\"markup--strong markup--pre-strong\">userDataReducer:</strong> userDataReducer,<br>    <strong class=\"markup--strong markup--pre-strong\">accountDataReducer:</strong> accountDataReducer<br>});</pre><h4 name=\"de89\" id=\"de89\" class=\"graf graf--h4 graf-after--pre\">Resetting State is as important as setting&nbsp;it</h4><p name=\"280f\" id=\"280f\" class=\"graf graf--p graf-after--h4\">When you start programming in Redux,resetting state is something you don’t worry about too much. However, interesting bugs will show up if you don’t reset your state well after significant actions like a route transition. It is usually UI state that you want to reset (you don’t want a dropdown expanded when a user comes to a new page). If you have separated UI state from the data state as described in <a href=\"https://medium.com/@uttamkini/scaling-redux-part-2-organizing-state-8a1c5e8fffbf\" data-href=\"https://medium.com/@uttamkini/scaling-redux-part-2-organizing-state-8a1c5e8fffbf\" class=\"markup--anchor markup--p-anchor\" target=\"_blank\">Scaling redux part 2</a>, then it is quite easy to reset UI state. You just have write a wrapper function/reducer over an existing UI subtree reducer like the following.</p><pre name=\"b7bb\" id=\"b7bb\" class=\"graf graf--pre graf-after--p\"><strong class=\"markup--strong markup--pre-strong\">const </strong>resettableReducer = (targetReducer, resetActionType) =&gt; {</pre><pre name=\"450c\" id=\"450c\" class=\"graf graf--pre graf-after--pre\"><em class=\"markup--em markup--pre-em\">    </em><strong class=\"markup--strong markup--pre-strong\">return </strong>(state, action) =&gt; {<br>      state = action.<strong class=\"markup--strong markup--pre-strong\">type </strong>=== resetActionType ? <strong class=\"markup--strong markup--pre-strong\">undefined </strong>: state;</pre><pre name=\"0d8f\" id=\"0d8f\" class=\"graf graf--pre graf-after--pre\">      <strong class=\"markup--strong markup--pre-strong\">const </strong>nextState = targetReducer(state, action);<br>      <strong class=\"markup--strong markup--pre-strong\">return </strong>nextState;<br>    };<br>};</pre><pre name=\"f7b9\" id=\"f7b9\" class=\"graf graf--pre graf-after--pre\">/* Usage */<br>resettableReducer(reducerWithRouteState,ROUTE_TRANSITION_ACTION)</pre><p name=\"cda7\" id=\"cda7\" class=\"graf graf--p graf-after--pre\">In the above example, whenever a `ROUTE_TRANSITION_ACTION` happens, all the state in `reducerWithRouteState` will be reset to the default state. If you have mixed your UI and data state trees, resetting state will get messy.</p><p name=\"97dd\" id=\"97dd\" class=\"graf graf--p graf-after--p graf--trailing\">That ends this post and mostly probably the series on Scaling Redux(unless I remember more stuff). My biggest takeaway after writing these posts, is that with complexity moving towards the front end, just using a framework is not enough. You need to have a solid technical architecture under the hood.</p>")
    )
}