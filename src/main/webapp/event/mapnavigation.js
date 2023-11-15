/**
 * Purpose: enable mouse wheel zoom
 * see https://api.highcharts.com/highmaps/mapNavigation.enabled
 * Based on version: 11.2.0
 */
zk.afterLoad('chart', function() {
    var exWidget = {};
    zk.override(chart.Charts.prototype, exWidget, {
		bind_: function(){
		    this.plotData.mapNavigation = {
                enabled:true,
		    };
			exWidget.bind_.apply(this, arguments);
		},
    });
});