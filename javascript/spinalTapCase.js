function spinalCase(str) {
    str = str.replace(/[A-Z]/g, (i, j) => { return (j ? '-' : '') + i});
    str = str.replace(/[\s]/g, (i) => { return (i ? '-' : '') });
    str = str.replace(/(_)/g, (i) => { return (i ? '' : '') });
    str = str.replace(/[-]{2,}/g, (i) => { return (i ? '-' : '') });

    return str.toLowerCase();
}
