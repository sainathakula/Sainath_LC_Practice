<h2><a href="https://leetcode.com/problems/shifting-letters-ii">Shifting Letters II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr><p>You are given a string <code>s</code> of lowercase English letters and a 2D integer array <code>shifts</code> where <code>shifts[i] = [start<sub>i</sub>, end<sub>i</sub>, direction<sub>i</sub>]</code>. For every <code>i</code>, <strong>shift</strong> the characters in <code>s</code> from the index <code>start<sub>i</sub></code> to the index <code>end<sub>i</sub></code> (<strong>inclusive</strong>) forward if <code>direction<sub>i</sub> = 1</code>, or shift the characters backward if <code>direction<sub>i</sub> = 0</code>.</p>

<p>Shifting a character <strong>forward</strong> means replacing it with the <strong>next</strong> letter in the alphabet (wrapping around so that <code>&#39;z&#39;</code> becomes <code>&#39;a&#39;</code>). Similarly, shifting a character <strong>backward</strong> means replacing it with the <strong>previous</strong> letter in the alphabet (wrapping around so that <code>&#39;a&#39;</code> becomes <code>&#39;z&#39;</code>).</p>

<p>Return <em>the final string after all such shifts to </em><code>s</code><em> are applied</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abc&quot;, shifts = [[0,1,0],[1,2,1],[0,2,1]]
<strong>Output:</strong> &quot;ace&quot;
<strong>Explanation:</strong> Firstly, shift the characters from index 0 to index 1 backward. Now s = &quot;zac&quot;.
Secondly, shift the characters from index 1 to index 2 forward. Now s = &quot;zbd&quot;.
Finally, shift the characters from index 0 to index 2 forward. Now s = &quot;ace&quot;.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;dztz&quot;, shifts = [[0,0,0],[1,1,1]]
<strong>Output:</strong> &quot;catz&quot;
<strong>Explanation:</strong> Firstly, shift the characters from index 0 to index 0 backward. Now s = &quot;cztz&quot;.
Finally, shift the characters from index 1 to index 1 forward. Now s = &quot;catz&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, shifts.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>shifts[i].length == 3</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt; s.length</code></li>
	<li><code>0 &lt;= direction<sub>i</sub> &lt;= 1</code></li>
	<li><code>s</code> consists of lowercase English letters.</li>
</ul>


<h1>Intuition</h1>
    <p>
        The problem states that we can apply a forward or backward shift to the characters of a string 
        based on the given start and end indices for each shift operation.
    </p>
    <p>
        The basic idea is to determine the shift values for each index in the given string.
    </p>
    <h2>Approach</h2>
    <p>
        A brute force solution leads to a Time Limit Exceeded (TLE) error due to the inefficiency of directly applying the shifts. 
        Let's explore a more optimal solution using a <strong>difference array</strong>.
    </p>
    <h3>Optimal Approach: Using a Difference Array</h3>
    <p>
        The difference array is a technique that efficiently computes relative changes in an array.
    </p>
    <h4>How the Difference Array Works</h4>
    <p>
        This method is based on the concept of relative change. We know the starting value, and the remaining values are 
        computed based on previous values.
    </p>
    <ul>
        <li>Create a new array of size <code>n+1</code> where <code>n</code> is the length of the string. 
            The extra space helps with handling the last index without out-of-bounds errors.</li>
        <li>For each shift operation, which has a <code>start</code>, <code>end</code>, and <code>direction</code>, 
            update the difference array:</li>
        <ul>
            <li>If the direction is forward, the value is <code>+1</</code>, and if backward, the value is <code>-1</code>.</li>
            <li>Update the difference array at <code>diff[start]</code> by adding the direction.</li>
            <li>Update <code>diff[end]</code> by subtracting the direction.</li>
        </ul>
        <li>Finally, calculate the cumulative sum of the difference array to obtain the actual shift values for each index.</li>
        <li>Once the net shift values are calculated, apply them to the string, adjusting the characters accordingly.</li>
        <li>If a negative shift occurs, convert it to a positive value (as alphabet shifts cycle every 26 characters) 
            and apply the forward shift.</li>
    </ul>
    <h2>Time and Space Complexity</h2>
    <h3>Time Complexity</h3>
    <p>
        The time complexity is <strong>O(n + m)</strong>, where:
    </p>
    <ul>
        <li><code>n</code> is the length of the string.</li>
        <li><code>m</code> is the number of shift operations.</li>
    </ul>
    <h3>Space Complexity</h3>
    <p>
        The space complexity is <strong>O(n)</strong> for the difference array.
    </p>

