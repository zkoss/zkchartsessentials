function export2server(){
    let chart = zk.Widget.$('$mychart'); //chart ID
    let parser = new DOMParser();
    let svgElem = parser.parseFromString(chart.engine.getSVG(), "image/svg+xml").documentElement;

    let serializer = new XMLSerializer();
    let svgString = serializer.serializeToString(svgElem);
    chart.fire('onExport', {image: svgString}, {toServer: true});
}