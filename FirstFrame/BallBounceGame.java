<html>
<head>
<title>BallBounceGame.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cc7832;}
.s1 { color: #a9b7c6;}
.s2 { color: #6a8759;}
.s3 { color: #6897bb;}
.s4 { color: #808080;}
</style>
</head>
<body bgcolor="#2b2b2b">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
BallBounceGame.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">FirstFrame</span><span class="s0">;</span>

<span class="s0">import </span><span class="s1">javax.swing.*</span><span class="s0">;</span>
<span class="s0">import </span><span class="s1">java.awt.*</span><span class="s0">;</span>
<span class="s0">import </span><span class="s1">java.awt.event.ActionEvent</span><span class="s0">;</span>
<span class="s0">import </span><span class="s1">java.awt.event.ActionListener</span><span class="s0">;</span>
<span class="s0">import </span><span class="s1">javax.swing.Timer</span><span class="s0">;</span>

<span class="s0">public class </span><span class="s1">BallBounceGame </span><span class="s0">extends </span><span class="s1">JFrame {</span>
    <span class="s0">private </span><span class="s1">CirclePanel circlePanel</span><span class="s0">;</span>

    <span class="s0">private int </span><span class="s1">circleX</span><span class="s0">, </span><span class="s1">circleY</span><span class="s0">, </span><span class="s1">circle2X</span><span class="s0">, </span><span class="s1">circle2Y</span><span class="s0">;</span>
    <span class="s0">private int </span><span class="s1">circleDiameter</span><span class="s0">, </span><span class="s1">circle2Diameter</span><span class="s0">;</span>
    <span class="s0">private int </span><span class="s1">circleXMovement</span><span class="s0">, </span><span class="s1">circle2XMovement</span><span class="s0">;</span>
    <span class="s0">private int </span><span class="s1">circleYMovement</span><span class="s0">, </span><span class="s1">circle2YMovement</span><span class="s0">;</span>
    <span class="s0">private </span><span class="s1">Color circleColor</span><span class="s0">, </span><span class="s1">circle2Color</span><span class="s0">;</span>

    <span class="s0">private int </span><span class="s1">rectangleX</span><span class="s0">, </span><span class="s1">rectangleY</span><span class="s0">;</span>
    <span class="s0">private int </span><span class="s1">rectangleWidth</span><span class="s0">, </span><span class="s1">rectangleHeight</span><span class="s0">;</span>
    <span class="s0">private int </span><span class="s1">rectangleXMovement</span><span class="s0">;</span>
    <span class="s0">private </span><span class="s1">Color rectangleColor</span><span class="s0">;</span>

    <span class="s0">public </span><span class="s1">BallBounceGame() {</span>
        <span class="s1">setTitle(</span><span class="s2">&quot;Moving Shapes&quot;</span><span class="s1">)</span><span class="s0">;</span>
        <span class="s1">setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)</span><span class="s0">;</span>

        <span class="s1">circlePanel = </span><span class="s0">new </span><span class="s1">CirclePanel()</span><span class="s0">;</span>
        <span class="s1">setLayout(</span><span class="s0">new </span><span class="s1">BorderLayout())</span><span class="s0">;</span>
        <span class="s1">add(circlePanel</span><span class="s0">, </span><span class="s1">BorderLayout.CENTER)</span><span class="s0">;</span>

        <span class="s1">circleX = </span><span class="s3">100</span><span class="s0">;</span>
        <span class="s1">circleY = </span><span class="s3">100</span><span class="s0">;</span>
        <span class="s1">circleDiameter = </span><span class="s3">50</span><span class="s0">;</span>
        <span class="s1">circleXMovement = </span><span class="s3">3</span><span class="s0">;</span>
        <span class="s1">circleYMovement = </span><span class="s3">2</span><span class="s0">;</span>
        <span class="s1">circleColor = Color.RED</span><span class="s0">;</span>

        <span class="s1">circle2X = </span><span class="s3">100</span><span class="s0">;</span>
        <span class="s1">circle2Y = </span><span class="s3">0</span><span class="s0">;  </span><span class="s4">// Modified to be at the top initially</span>
        <span class="s1">circle2Diameter = </span><span class="s3">100</span><span class="s0">;</span>
        <span class="s1">circle2XMovement = </span><span class="s3">3</span><span class="s0">;</span>
        <span class="s1">circle2YMovement = </span><span class="s3">0</span><span class="s0">;  </span><span class="s4">// Modified to have no vertical movement</span>
        <span class="s1">circle2Color = Color.RED</span><span class="s0">;</span>

        <span class="s0">int </span><span class="s1">delay = </span><span class="s3">10</span><span class="s0">;</span>
        <span class="s1">Timer timer = </span><span class="s0">new </span><span class="s1">Timer(delay</span><span class="s0">, new </span><span class="s1">TimerListener())</span><span class="s0">;</span>
        <span class="s1">timer.start()</span><span class="s0">;</span>

        <span class="s1">pack()</span><span class="s0">;</span>
        <span class="s1">setLocationRelativeTo(</span><span class="s0">null</span><span class="s1">)</span><span class="s0">;</span>
        <span class="s1">setVisible(</span><span class="s0">true</span><span class="s1">)</span><span class="s0">;</span>
    <span class="s1">}</span>

    <span class="s0">public static void </span><span class="s1">main(String[] args) {</span>
        <span class="s0">new </span><span class="s1">BallBounceGame()</span><span class="s0">;</span>
    <span class="s1">}</span>

    <span class="s0">private class </span><span class="s1">CirclePanel </span><span class="s0">extends </span><span class="s1">JPanel {</span>
        <span class="s1">@Override</span>
        <span class="s0">protected void </span><span class="s1">paintComponent(Graphics g) {</span>
            <span class="s0">super</span><span class="s1">.paintComponent(g)</span><span class="s0">;</span>
            <span class="s1">g.setColor(circleColor)</span><span class="s0">;</span>
            <span class="s1">g.fillOval(circleX</span><span class="s0">, </span><span class="s1">circleY</span><span class="s0">, </span><span class="s1">circleDiameter</span><span class="s0">, </span><span class="s1">circleDiameter)</span><span class="s0">;</span>
            <span class="s1">g.setColor(circle2Color)</span><span class="s0">;</span>
            <span class="s1">g.fillOval(circle2X</span><span class="s0">, </span><span class="s1">circle2Y</span><span class="s0">, </span><span class="s1">circle2Diameter</span><span class="s0">, </span><span class="s1">circle2Diameter)</span><span class="s0">;</span>
        <span class="s1">}</span>

        <span class="s1">@Override</span>
        <span class="s0">public </span><span class="s1">Dimension getPreferredSize() {</span>
            <span class="s0">return new </span><span class="s1">Dimension(</span><span class="s3">400</span><span class="s0">, </span><span class="s3">400</span><span class="s1">)</span><span class="s0">;</span>
        <span class="s1">}</span>

        <span class="s0">public boolean </span><span class="s1">contains(</span><span class="s0">int </span><span class="s1">x</span><span class="s0">, int </span><span class="s1">y) {</span>
            <span class="s0">int </span><span class="s1">centerX = circleX + circleDiameter / </span><span class="s3">2</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">centerY = circleY + circleDiameter / </span><span class="s3">2</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">center2X = circle2X + circle2Diameter / </span><span class="s3">2</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">center2Y = circle2Y + circle2Diameter / </span><span class="s3">2</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">dx = x - centerX</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">dy = y - centerY</span><span class="s0">;</span>
            <span class="s0">double </span><span class="s1">distance = Math.sqrt(dx * dx + dy * dy)</span><span class="s0">;</span>
            <span class="s0">return </span><span class="s1">distance &lt; circleDiameter / </span><span class="s3">2 </span><span class="s1">&amp; distance &lt; circle2Diameter / </span><span class="s3">2</span><span class="s0">;</span>
        <span class="s1">}</span>
    <span class="s1">}</span>

    <span class="s0">private class </span><span class="s1">TimerListener </span><span class="s0">implements </span><span class="s1">ActionListener {</span>
        <span class="s1">@Override</span>
        <span class="s0">public void </span><span class="s1">actionPerformed(ActionEvent e) {</span>
            <span class="s4">// Check for collision between the two circles</span>
            <span class="s0">if </span><span class="s1">(isColliding(circleX</span><span class="s0">, </span><span class="s1">circleY</span><span class="s0">, </span><span class="s1">circleDiameter</span><span class="s0">, </span><span class="s1">circle2X</span><span class="s0">, </span><span class="s1">circle2Y</span><span class="s0">, </span><span class="s1">circle2Diameter)) {</span>
                <span class="s4">// Swap the movements of the circles</span>
                <span class="s0">int </span><span class="s1">tempXMovement = circleXMovement</span><span class="s0">;</span>
                <span class="s0">int </span><span class="s1">tempYMovement = circleYMovement</span><span class="s0">;</span>
                <span class="s1">circleXMovement = circle2XMovement</span><span class="s0">;</span>
                <span class="s1">circleYMovement = circle2YMovement</span><span class="s0">;</span>
                <span class="s1">circle2XMovement = tempXMovement</span><span class="s0">;</span>
                <span class="s1">circle2YMovement = tempYMovement</span><span class="s0">;</span>

                <span class="s4">// Change the colors of the circles</span>
                <span class="s1">circleColor = Color.BLUE</span><span class="s0">;</span>
                <span class="s1">circle2Color = Color.GREEN</span><span class="s0">;</span>
            <span class="s1">}</span>

            <span class="s4">// Update the positions of the circles</span>
            <span class="s1">circleX += circleXMovement</span><span class="s0">;</span>
            <span class="s1">circleY += circleYMovement</span><span class="s0">;</span>
            <span class="s1">circle2X += circle2XMovement</span><span class="s0">;</span>

            <span class="s4">// Handle boundary collisions for the first circle</span>
            <span class="s0">if </span><span class="s1">(circleX &lt;= </span><span class="s3">0 </span><span class="s1">|| circleX &gt;= getWidth() - circleDiameter) {</span>
                <span class="s1">circleXMovement *= -</span><span class="s3">1</span><span class="s0">;</span>
                <span class="s1">circleColor = Color.BLUE</span><span class="s0">;</span>
            <span class="s1">}</span>
            <span class="s0">if </span><span class="s1">(circleY &lt;= </span><span class="s3">0 </span><span class="s1">|| circleY &gt;= getHeight() - circleDiameter) {</span>
                <span class="s1">circleYMovement *= -</span><span class="s3">1</span><span class="s0">;</span>
                <span class="s1">circleColor = Color.RED</span><span class="s0">;</span>
            <span class="s1">}</span>

            <span class="s4">// Handle boundary collisions for the second circle</span>
            <span class="s0">if </span><span class="s1">(circle2X &lt;= </span><span class="s3">0 </span><span class="s1">|| circle2X &gt;= getWidth() - circle2Diameter) {</span>
                <span class="s1">circle2XMovement *= -</span><span class="s3">1</span><span class="s0">;</span>
                <span class="s1">circle2Color = Color.GRAY</span><span class="s0">;</span>
            <span class="s1">}</span>

            <span class="s1">circlePanel.repaint()</span><span class="s0">;</span>
        <span class="s1">}</span>

        <span class="s4">// Check if two circles are colliding</span>
        <span class="s0">private boolean </span><span class="s1">isColliding(</span><span class="s0">int </span><span class="s1">x1</span><span class="s0">, int </span><span class="s1">y1</span><span class="s0">, int </span><span class="s1">diameter1</span><span class="s0">, int </span><span class="s1">x2</span><span class="s0">, int </span><span class="s1">y2</span><span class="s0">, int </span><span class="s1">diameter2) {</span>
            <span class="s0">int </span><span class="s1">centerX1 = x1 + diameter1 / </span><span class="s3">2</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">centerY1 = y1 + diameter1 / </span><span class="s3">2</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">centerX2 = x2 + diameter2 / </span><span class="s3">2</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">centerY2 = y2 + diameter2 / </span><span class="s3">2</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">dx = centerX2 - centerX1</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">dy = centerY2 - centerY1</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">distanceSquared = dx * dx + dy * dy</span><span class="s0">;</span>
            <span class="s0">int </span><span class="s1">radiusSumSquared = (diameter1 / </span><span class="s3">2 </span><span class="s1">+ diameter2 / </span><span class="s3">2</span><span class="s1">) * (diameter1 / </span><span class="s3">2 </span><span class="s1">+ diameter2 / </span><span class="s3">2</span><span class="s1">)</span><span class="s0">;</span>
            <span class="s0">return </span><span class="s1">distanceSquared &lt;= radiusSumSquared</span><span class="s0">;</span>
        <span class="s1">}</span>
    <span class="s1">}</span>
<span class="s1">}</span>

</pre>
</body>
</html>
