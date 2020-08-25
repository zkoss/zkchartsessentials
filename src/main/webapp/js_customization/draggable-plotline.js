/** purpose: make a plotline draggable.
* based on: zkcharts 7.2.1.1
**/

zk.afterLoad('chart', function() {
    var line, label, clickX, clickY;

    var step = function(e) {
        line.translate(e.pageX - clickX, 0);
        if (label){
          label.translate(e.pageX - clickX, e.pageY - clickY)
        }
    }

    var stop = function() {
        $(document).unbind('.line');
    }

    var start = function(e) {
        $(document).bind({
          'mousemove.line': step,
          'mouseup.line': stop,
        'mousemove': function(){console.log('move')}
        });

        clickX = e.pageX - line.translateX;
        //clickY = e.pageY - line.translateY; //uncomment if plotline should be also moved vertically
    }
    var highchart = zk.Widget.$('$chart').engine;
    line = highchart.xAxis[0].plotLinesAndBands[0].svgElem
          .css({
            'cursor': 'pointer'
          })
          .translate(0, 0)
          .on('mousedown', start);

});
