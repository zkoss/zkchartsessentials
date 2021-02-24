/**
 * Purpose: enable mouse wheel zoom
 * see https://api.highcharts.com/highmaps/6.0.2/mapNavigation.enabled
 * Based on version: 7.2.1.2
 */
zk.afterLoad('chart', function() {
    var exWidget = {};
    zk.override(chart.Charts.prototype, exWidget, {
		bind_: function(){
		    this.plotData.mapNavigation = {
                enabled:true,
                enableButtons: false,
		    };
			exWidget.bind_.apply(this, arguments);
		},
    });
});